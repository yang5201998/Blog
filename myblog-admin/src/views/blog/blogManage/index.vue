<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="博客标题" prop="blogTitle">
        <el-input
          v-model="queryParams.title"
          placeholder="请输入博客标题"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="分类名称" prop="blogSortName">
      <el-select v-model="formInline.blogSortName" multiple collapse-tag placeholder="请选择分类名称">
       <el-option
          v-for="item in blogSortNames"
          :key="item.value"
          :label="item.label"
          :value="item.value">
        </el-option>
      </el-select>
      </el-form-item>
      <el-form-item label="标签名称" prop="blogTagName">
      <el-select v-model="formInline.blogTagName" multiple collapse-tag placeholder="请选择标签名称">
       <el-option
          v-for="item in blogTagNames"
          :key="item.value"
          :label="item.label"
          :value="item.value">
        </el-option>
      </el-select>
      </el-form-item>
      <el-form-item label="推荐等级" prop="level">
        <el-select
          v-model="queryParams.level"
          placeholder="推荐等级"
          clearable
          style="width: 240px"
        >
          <el-option
            v-for="dict in dict.type.blog_level"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
        <el-form-item label="发布状态" prop="status">
        <el-select
          v-model="queryParams.status"
          placeholder="发布状态"
          clearable
          style="width: 240px"
        >
          <el-option
            v-for="dict in dict.type.blog_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['manage:blogManage:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['manage:blogManage:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['manage:blogManage:remove']"
        >删除</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="blogManageList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="序号" align="center" prop="id" />
      <el-table-column label="博客标题" align="center" prop="blogTitle" />
      <el-table-column label="博客简介" align="center" prop="summary" />
      <el-table-column label="博客内容" align="center" prop="content" />
      <el-table-column label="标签uid" align="center" prop="tagUid" />
      <el-table-column label="博客点击数" align="center" prop="clickCount" />
      <el-table-column label="博客收藏数" align="center" prop="collectCount" />
      <el-table-column label="标题图片uid" align="center" prop="fileUid" />
      <el-table-column label="状态" align="center" prop="status" />
      <el-table-column label="管理员uid" align="center" prop="adminUid" />
      <el-table-column label="作者" align="center" prop="author" />
      <el-table-column label="博客分类UID" align="center" prop="blogSortUid" />
      <el-table-column label="推荐等级(0:正常)" align="center" prop="level" />
      <el-table-column label="是否发布：0：否，1：是" align="center" prop="isPublish" />
      <el-table-column label="排序字段" align="center" prop="sort" />
      <el-table-column label="是否开启评论(0:否 1:是)" align="center" prop="openComment" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['manage:blogManage:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['manage:blogManage:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改博客管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="博客标题" prop="title">
          <el-input v-model="form.title" placeholder="请输入博客标题" />
        </el-form-item>
        <el-form-item label="博客简介" prop="summary">
          <el-input v-model="form.summary" placeholder="请输入博客简介" />
        </el-form-item>
        <el-form-item label="博客内容">
          <editor v-model="form.content" :min-height="192"/>
        </el-form-item>
        <el-form-item label="博客点击数" prop="clickCount">
          <el-input v-model="form.clickCount" placeholder="请输入博客点击数" />
        </el-form-item>
        <el-form-item label="博客收藏数" prop="collectCount">
          <el-input v-model="form.collectCount" placeholder="请输入博客收藏数" />
        </el-form-item>
        <el-form-item label="标题图片uid" prop="fileUid">
          <el-input v-model="form.fileUid" placeholder="请输入标题图片uid" />
        </el-form-item>
        <el-form-item label="管理员uid" prop="adminUid">
          <el-input v-model="form.adminUid" placeholder="请输入管理员uid" />
        </el-form-item>
        <el-form-item label="作者" prop="author">
          <el-input v-model="form.author" placeholder="请输入作者" />
        </el-form-item>
        <el-form-item label="推荐等级(0:正常)" prop="level">
          <el-input v-model="form.level" placeholder="请输入推荐等级(0:正常)" />
        </el-form-item>
        <el-form-item label="是否发布：0：否，1：是" prop="isPublish">
          <el-input v-model="form.isPublish" placeholder="请输入是否发布：0：否，1：是" />
        </el-form-item>
        <el-form-item label="排序字段" prop="sort">
          <el-input v-model="form.sort" placeholder="请输入排序字段" />
        </el-form-item>
        <el-form-item label="是否开启评论(0:否 1:是)" prop="openComment">
          <el-input v-model="form.openComment" placeholder="请输入是否开启评论(0:否 1:是)" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listBlogManage, getBlogManage, delBlogManage, addBlogManage, updateBlogManage } from "@/api/blog/blogManage";

export default {
  name: "BlogManage",
  dicts: ['blog_level','blog_status'],
  data() {
    return {
      blogSortNames:[],

      blogTagNames:[],
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 博客管理表格数据
      blogManageList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        title: null,
        summary: null,
        content: null,
        tagUid: null,
        clickCount: null,
        collectCount: null,
        fileUid: null,
        status: null,
        adminUid: null,
        author: null,
        blogSortUid: null,
        level: null,
        isPublish: null,
        sort: null,
        openComment: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        status: [
          { required: true, message: "状态不能为空", trigger: "blur" }
        ],
        createTime: [
          { required: true, message: "创建时间不能为空", trigger: "blur" }
        ],
        updateTime: [
          { required: true, message: "更新时间不能为空", trigger: "blur" }
        ],
        sort: [
          { required: true, message: "排序字段不能为空", trigger: "blur" }
        ],
        openComment: [
          { required: true, message: "是否开启评论(0:否 1:是)不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询博客管理列表 */
    getList() {
      this.loading = true;
      listBlogManage(this.queryParams).then(response => {
        this.blogManageList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        uid: null,
        title: null,
        summary: null,
        content: null,
        tagUid: null,
        clickCount: null,
        collectCount: null,
        fileUid: null,
        status: 0,
        createTime: null,
        updateTime: null,
        adminUid: null,
        author: null,
        blogSortUid: null,
        level: null,
        isPublish: null,
        sort: null,
        openComment: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.uid)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加博客管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const uid = row.uid || this.ids
      getBlogManage(uid).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改博客管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.uid != null) {
            updateBlogManage(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addBlogManage(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const uids = row.uid || this.ids;
      this.$modal.confirm('是否确认删除博客管理编号为"' + uids + '"的数据项？').then(function() {
        return delBlogManage(uids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('manage/blogManage/export', {
        ...this.queryParams
      }, `blogManage_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
