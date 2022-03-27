#!/bin/sh

# 复制项目的文件到对应docker路径，便于一键生成镜像。
usage() {
	echo "Usage: sh copy.sh"
	exit 1
}


# copy sql
echo "begin copy sql "
cp ../sql/ry_20210908.sql ./mysql/db
cp ../sql/ry_config_20220114.sql ./mysql/db

# copy html
echo "begin copy html "
cp -r ../blog-ui/dist/** ./nginx/html/dist


# copy jar
echo "begin copy blog-gateway "
cp ../blog-gateway/target/blog-gateway.jar ./blog/gateway/jar

echo "begin copy blog-auth "
cp ../blog-auth/target/blog-auth.jar ./blog/auth/jar

echo "begin copy blog-visual "
cp ../blog-visual/blog-monitor/target/blog-visual-monitor.jar  ./blog/visual/monitor/jar

echo "begin copy blog-modules-system "
cp ../blog-modules/blog-system/target/blog-modules-system.jar ./blog/modules/system/jar

echo "begin copy blog-modules-file "
cp ../blog-modules/blog-file/target/blog-modules-file.jar ./blog/modules/file/jar

echo "begin copy blog-modules-job "
cp ../blog-modules/blog-job/target/blog-modules-job.jar ./blog/modules/job/jar

echo "begin copy blog-modules-gen "
cp ../blog-modules/blog-gen/target/blog-modules-gen.jar ./blog/modules/gen/jar

