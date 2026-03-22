<template>
  <div class="app-container home">
    <el-header class="main-header">
      <div class="header-left">
        <div class="logo">
          <i class="el-icon-camera-solid" style="font-size: 24px; color: #409EFF; margin-right: 10px;"></i>
          <span class="logo-text">Simo.</span>
        </div>
        <div class="nav-links">
          <span class="nav-link active">工作台首页</span>
          <span class="nav-link" @click="goTarget('/photos')">我的图库</span>
          <span class="nav-link" @click="goTarget('/albums')">智能相册</span>
          <span class="nav-link" @click="goTarget('/forum')">摄影社区</span>
        </div>
      </div>
    </el-header>

    <div class="main-content">
      <el-row :gutter="20">
        <el-col :sm="24" :lg="12" style="padding-left: 20px; margin-top: 40px;">
          <h1 class="main-title">摄影作品智能管理与分类系统</h1>
          <p class="main-description">
            本系统专为摄影师和摄影爱好者设计，旨在解决海量摄影作品的管理难题。通过深度学习(ResNet/CLIP)人工智能技术，
            实现对摄影作品的智能分类、自动标签识别、专业参数提取(RAW/EXIF)和高效检索，让您从繁琐的后期整理工作中彻底解放。
          </p>
          <div style="margin-top: 30px;">
            <el-button type="primary" size="medium" icon="el-icon-upload" @click="goTarget('/photos')">去上传作品</el-button>
            <el-button type="default" size="medium" icon="el-icon-magic-stick" @click="goTarget('/albums')">查看AI相册</el-button>
          </div>
        </el-col>

        <el-col :sm="24" :lg="12" style="padding-left: 50px; margin-top: 40px;">
          <el-row :gutter="20">
            <el-col :span="12">
              <el-card shadow="hover" class="feature-card" @click.native="goTarget('/photos')">
                <div slot="header" class="clearfix">
                  <span><i class="el-icon-picture"></i> 图库管理</span>
                </div>
                <div class="feature-body">
                  支持 RAW 格式解析，精准提取设备与曝光参数，自定义权限分享。
                </div>
              </el-card>
            </el-col>
            <el-col :span="12">
              <el-card shadow="hover" class="feature-card" @click.native="goTarget('/albums')">
                <div slot="header" class="clearfix">
                  <span><i class="el-icon-files"></i> AI 智能聚类</span>
                </div>
                <div class="feature-body">
                  基于 Python 图像识别大模型，自动打标并聚类生成风景、人像等相册。
                </div>
              </el-card>
            </el-col>
          </el-row>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
export default {
  name: "Index",
  data() {
    return {
      // 版本号
      version: "3.8.8"
    };
  },
  methods: {
    /**
     * 【核心路由跳转逻辑】
     * 为什么这么写：用户在首页点击自定义导航栏时，
     * 我们通过 Vue Router 的 push 方法，将它们隐式转换为若依后台的真实菜单路径。
     */
    goTarget(path) {
      // 路由字典映射，将你的快捷路径映射到生成的代码路径上
      const routeMap = {
        '/photos': '/gallery/photo',   // 映射到图片管理列表
        '/albums': '/gallery/album',   // 映射到相册管理列表
        '/forum':  '/gallery/post'     // 映射到论坛帖子列表
      };
      
      const targetPath = routeMap[path];
      if (targetPath) {
        // 利用若依自带的 router 对象实现无缝无刷新的页面跳转
        this.$router.push(targetPath).catch(err => {
          console.warn("路由跳转异常:", err);
        });
      } else {
        this.$message.warning("正在开发中，敬请期待！");
      }
    }
  }
};
</script>

<style scoped lang="scss">
.home {
  background-color: #f5f7fa;
  min-height: calc(100vh - 84px);
  padding: 0;

  .main-header {
    background: #fff;
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.05);
    display: flex;
    align-items: center;
    padding: 0 40px;
    height: 70px !important;

    .header-left {
      display: flex;
      align-items: center;
      width: 100%;

      .logo {
        display: flex;
        align-items: center;
        margin-right: 60px;
        
        .logo-text {
          font-size: 22px;
          font-weight: bold;
          color: #303133;
        }
      }

      .nav-links {
        display: flex;
        gap: 30px;

        .nav-link {
          font-size: 16px;
          color: #606266;
          cursor: pointer;
          transition: color 0.3s;
          padding: 10px 0;

          &:hover {
            color: #409EFF;
          }

          &.active {
            color: #409EFF;
            font-weight: bold;
            border-bottom: 2px solid #409EFF;
          }
        }
      }
    }
  }

  .main-content {
    padding: 40px;
    
    .main-title {
      font-size: 36px;
      color: #303133;
      margin-bottom: 20px;
      font-weight: 600;
      letter-spacing: 1px;
    }

    .main-description {
      font-size: 16px;
      color: #606266;
      line-height: 1.8;
      margin-bottom: 40px;
      max-width: 90%;
    }

    .feature-card {
      height: 160px;
      margin-bottom: 20px;
      transition: all 0.3s;
      cursor: pointer;
      border-radius: 8px;
      
      &:hover {
        transform: translateY(-5px);
        box-shadow: 0 8px 24px rgba(0,0,0,0.1);
        border-color: #409EFF;
      }

      .clearfix {
        font-weight: bold;
        color: #303133;
      }
      
      .feature-body {
        font-size: 14px;
        color: #666;
        line-height: 1.6;
        padding-top: 10px;
      }
    }
  }
}
</style>