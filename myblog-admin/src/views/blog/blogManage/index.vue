<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="博客标题" prop="blogTitle">
        <el-input
          v-model="queryParams.blogTitle"
          placeholder="请输入博客标题"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="分类名称" prop="blogSortName">
      <el-select v-model="queryParams.blogSortName" multiple collapse-tag placeholder="请选择分类名称">
       <el-option
          v-for="item in blogSortNames"
          :key="item"
          :label="item"
          :value="item">
        </el-option>
      </el-select>
      </el-form-item>
      <el-form-item label="标签名称" prop="blogTagName">
      <el-select v-model="queryParams.blogTagName" multiple collapse-tag placeholder="请选择标签名称">
       <el-option
          v-for="item in blogTagNames"
          :key="item"
          :label="item"
          :value="item">
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
        <el-form-item label="发布状态"  prop="status">
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
      <el-form-item label="创建时间">
        <el-date-picker
          v-model="dateRange"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
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
       <el-table-column type="expand">
      <template slot-scope="scope">
        <el-form label-position="left" inline class="demo-table-expand">
          <el-form-item label="博客标题">
            <span>{{ scope.row.blogTitle }}</span>
          </el-form-item>
          <el-form-item label="博客分类"  >
            <span  v-for="item in scope.row.blogSortName">{{ item.blogSortName }} </span>
          </el-form-item>
          <el-form-item label="博客简介">
            <span>{{ scope.row.summary }}</span>
          </el-form-item>
          <el-form-item label="博客作者">
            <span>{{ scope.row.author }}</span>
          </el-form-item>
          <el-form-item label="博客标签">
            <span v-for="item in scope.row.blogTagName" >{{ item.tagName }} </span>
          </el-form-item>
          <el-form-item label="博客等级">
            <span v-for="dict in dict.type.blog_level"
              v-if="dict.value==scope.row.level">
            {{dict.label}} </span>
          </el-form-item>
          <el-table-column label="创建时间" align="center" prop="createTime" width="180">
          <template slot-scope="scope">
            <span>{{ parseTime(scope.row.createTime) }}</span>
          </template>
        </el-table-column>
          <!-- <el-form-item label="创建时间">
            <span>{{ scope.row.createTime }}</span>
          </el-form-item> -->
         <el-table-column label="修改时间" align="center" prop="updateTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.updateTime) }}</span>
        </template>
      </el-table-column>
          <!-- <el-form-item label="修改时间">
            <span>{{ scope.row.updateTime }}</span>
          </el-form-item> -->
        </el-form>
      </template>
    </el-table-column>
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="序号" align="center" width="55" prop="id" />
      <el-table-column label="标题图片" align="center" width="80" prop="imgUrl" >
     <template slot-scope="scope">
      <el-image
      style="width: 80px; height: 80px"
      :src="scope.row.imgUrl"
      :fit=fit></el-image>
     </template>
      </el-table-column>
      <el-table-column label="标题" :show-overflow-tooltip="true" align="center" width="150" prop="blogTitle" >
        <template slot-scope="scope">
          <span @click="onClick(scope.row)" style="cursor:pointer;">{{ scope.row.blogTitle }}</span>
        </template>
      </el-table-column>
      <el-table-column label="分类" align="center" width="100" prop="blogSort" >
       <template slot-scope="scope">
        <el-tag
              style="margin-left: 3px"
              type="success"
              :key="item.blogSortName"
              v-for="item in scope.row.blogSortName"
            >{{item.blogSortName}}</el-tag>
      </template>
      </el-table-column>
      <el-table-column label="标签" align="center" width="100" prop="blogTag" >
        <template slot-scope="scope">
        <el-tag
              style="margin-left: 3px"
              type="danger"
              :key="item.content"
              v-for="item in scope.row.blogTagName"
            >{{item.tagName}}</el-tag>
      </template>
      </el-table-column>
      <el-table-column label="点击数" sortable align="center" width="100" prop="clickCount" />
      <el-table-column label="收藏数" sortable align="center"  width="100" prop="collectCount" />
      <el-table-column label="发布状态" align="center" prop="status" >
         <template slot-scope="scope">
          <el-switch
            v-model="scope.row.status"
            :active-value="0"
            :inactive-value="1"
            @change="handleStatusChange(scope.row)"
          ></el-switch>
        </template>
      </el-table-column>
      <el-table-column label="推荐等级" align="center" prop="level" >
       <template slot-scope="scope">
        <el-tag
              style="margin-left: 3px"
              type=" "
              :key="scope.row.level"
              v-for="dict in dict.type.blog_level"
              v-if="dict.value==scope.row.level"
            >{{dict.label}}</el-tag>
      </template>
      </el-table-column>
      <el-table-column label="开启评论" align="center" prop="openComment">
         <template slot-scope="scope">
          <el-switch
            v-model="scope.row.openComment"
            :active-value="0"
            :inactive-value="1"
            @change="handleCommentChange(scope.row)"
          ></el-switch>
        </template>
      </el-table-column>
       <el-table-column label="创建时间" sortable align="center"  prop="createTime" width="160">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime) }}</span>
        </template>
      </el-table-column>
            <el-table-column label="修改时间" sortable align="center" prop="updateTime" width="160">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.updateTime) }}</span>
        </template>
      </el-table-column>
      <el-table-column  fixed='right' label="操作" align="center" class-name="small-padding fixed-width">
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
        <el-form-item label="博客点击数" prop="clickCount">
          <el-input v-model="form.clickCount" placeholder="请输入博客点击数" />
        </el-form-item>
        <el-form-item label="博客收藏数" prop="collectCount">
          <el-input v-model="form.collectCount" placeholder="请输入博客收藏数" />
        </el-form-item>
        <el-form-item label="标题图片uid" prop="fileUid">
          <el-input v-model="form.fileUid" placeholder="请输入标题图片uid" />
        </el-form-item>
        <el-form-item label="作者" prop="author">
          <el-input v-model="form.author" placeholder="请输入作者" />
        </el-form-item>
        <el-form-item label="推荐等级(0:正常)" prop="level">
          <el-input v-model="form.level" placeholder="请输入推荐等级(0:正常)" />
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
import { listBlogManage, getBlogManage, delBlogManage, addBlogManage, updateBlogManage,listSortAndTag,changeBlogStatus,changeBlogComment } from "@/api/blog/blogManage";

export default {
  name: "BlogManage",
  dicts: ['blog_level','blog_status'],
  data() {
    return {
      blogSortNames:[],
      blogTagNames:[],
      fit:'fill',
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
      // 日期范围
      dateRange: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        blogTitle: null,
        summary: null,
        content: null,
        tagUid:null,
        blogTagName: [],
        clickCount: null,
        collectCount: null,
        imgUid: null,
        imgUrl:null,
        status: null,
        author: null,
        blogSortUid: null,
        blogSortName: [],
        level: null,
        sort: null,
        openComment: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        status: [
          { required: true, message: "发布状态不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
    this.getSortAndTagList();
  },
  methods: {
  
    /** 查询博客管理列表 */
    getList() {
      this.loading = true;
      listBlogManage(this.addDateRange(this.queryParams, this.dateRange)).then(response => {
        console.log("response",response)
        this.blogManageList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
        /** 获取博客分类和标签列表 */
    getSortAndTagList() {
      this.loading = true;
      listSortAndTag().then(response => {
        console.log("response.listSortAndTag",response)
        this.blogSortNames=response.data.blogSortNames;
        this.blogTagNames=response.data.blogTagNames;
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
        blogTitle: null,
        summary: null,
        content: null,
        blogTagName: [],
        clickCount: null,
        collectCount: null,
        imgUrl:null,
        status: 0,
        createTime: null,
        updateTime: null,
        adminUid: null,
        author: null,
        blogSortName: [],
        level: null,
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
      this.dateRange = [];
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
            // 发布状态修改
    handleStatusChange(row) {
      console.log("Statusrow",row)
      let text = row.status === 0 ? "发布" : "下架";
      this.$modal.confirm('确认要"' + text + '""' + row.blogTitle + '"博客吗？').then(function() {
        return updateBlogManage(row);
      }).then(() => {
        this.$modal.msgSuccess(text + "成功");
      }).catch(function() {
        row.status = row.status === 0 ? 0 : 1;
      });
    },
            // 是否开启评论
    handleCommentChange(row) {
      console.log("Commentrow",row)
      let text = row.openComment === 0 ? "启用" : "停用";
      this.$modal.confirm('确认要"' + text + '""' + row.blogTitle + '"评论吗？').then(function() {
        return updateBlogManage(row);
      }).then(() => {
        this.$modal.msgSuccess(text + "成功");
      }).catch(function() {
        row.openComment = row.openComment === 0 ? 0 : 1;
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
<style>
  .demo-table-expand {
    font-size: 0;
  }
  .demo-table-expand label {
    width: 90px;
    color: #99a9bf;
  }
  .demo-table-expand .el-form-item {
    margin-right: 0;
    margin-bottom: 0;
    width: 50%;
  }

</style>