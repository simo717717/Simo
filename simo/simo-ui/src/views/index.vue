<template>
  <div class="app-container home">
    <!-- 顶部导航栏 -->
    <el-header class="main-header">
      <div class="header-left">
        <div class="logo">
          <i class="el-icon-camera-solid" style="font-size: 24px; color: #409EFF; margin-right: 10px;"></i>
          <span class="logo-text">Simo.</span>
        </div>
        <div class="nav-links">
          <span class="nav-link active">首页</span>
          <span class="nav-link" @click="goTarget('/photos')">图库</span>
          <span class="nav-link" @click="goTarget('/search')">搜索</span>
          <span class="nav-link" @click="goTarget('/forum')">社区</span>
        </div>
      </div>
    </el-header>

    <!-- 主内容区域 -->
    <div class="main-content">
      <el-row :gutter="20">
        <el-col :sm="24" :lg="12" style="padding-left: 20px">
          <h1 class="main-title">摄影作品智能管理与分类系统</h1>
          <p class="main-description">
            本系统专为摄影师和摄影爱好者设计，旨在解决海量摄影作品的管理难题。通过人工智能技术，
            实现对摄影作品的智能分类、标签识别、聚类分析和高效检索，让您从繁琐的整理工作中解放出来，
            更专注于创作本身。
          </p>
          <div class="system-info">
            <p>
              <span class="info-label">当前版本:</span> <span class="info-value">v1.0.0</span>
            </p>
            <div class="tags">
              <el-tag type="success" size="medium">智能摄影管理</el-tag>
              <el-tag type="primary" size="medium" style="margin-left: 10px">AI赋能</el-tag>
              <el-tag type="warning" size="medium" style="margin-left: 10px">专业工具</el-tag>
            </div>
          </div>
          <div class="action-buttons">
            <el-button
              type="primary"
              size="medium"
              icon="el-icon-picture"
              @click="goTarget('/photos')"
              >进入图库</el-button
            >
            <el-button
              type="success"
              size="medium"
              icon="el-icon-upload2"
              @click="goTarget('/upload')"
              style="margin-left: 15px"
              >上传图片</el-button
            >
            <el-button
              size="medium"
              icon="el-icon-search"
              plain
              @click="goTarget('/search')"
              style="margin-left: 15px"
              >智能搜索</el-button
            >
          </div>
        </el-col>

        <el-col :sm="24" :lg="12" style="padding-left: 50px">
          <div class="tech-architecture">
            <h2 class="section-title">技术架构</h2>
            <el-divider style="margin: 15px 0 25px 0;"></el-divider>
            <el-row :gutter="30">
              <el-col :span="8">
                <div class="tech-category">
                  <div class="tech-icon" style="background: #f0f9ff; color: #409EFF;">
                    <i class="el-icon-monitor"></i>
                  </div>
                  <h4>前端技术</h4>
                  <ul>
                    <li><i class="el-icon-check" style="color: #67C23A; margin-right: 5px;"></i>Vue3</li>
                    <li><i class="el-icon-check" style="color: #67C23A; margin-right: 5px;"></i>Element-Plus</li>
                    <li><i class="el-icon-check" style="color: #67C23A; margin-right: 5px;"></i>Axios</li>
                    <li><i class="el-icon-check" style="color: #67C23A; margin-right: 5px;"></i>Vue Router</li>
                  </ul>
                </div>
              </el-col>
              <el-col :span="8">
                <div class="tech-category">
                  <div class="tech-icon" style="background: #f0f2ff; color: #5a6fd9;">
                    <i class="el-icon-cpu"></i>
                  </div>
                  <h4>后端技术</h4>
                  <ul>
                    <li><i class="el-icon-check" style="color: #67C23A; margin-right: 5px;"></i>Spring Boot</li>
                    <li><i class="el-icon-check" style="color: #67C23A; margin-right: 5px;"></i>Spring Security</li>
                    <li><i class="el-icon-check" style="color: #67C23A; margin-right: 5px;"></i>MyBatis</li>
                    <li><i class="el-icon-check" style="color: #67C23A; margin-right: 5px;"></i>MySQL</li>
                  </ul>
                </div>
              </el-col>
              <el-col :span="8">
                <div class="tech-category">
                  <div class="tech-icon" style="background: #f0fff4; color: #67C23A;">
                    <i class="el-icon-data-analysis"></i>
                  </div>
                  <h4>AI技术</h4>
                  <ul>
                    <li><i class="el-icon-check" style="color: #67C23A; margin-right: 5px;"></i>ResNet模型</li>
                    <li><i class="el-icon-check" style="color: #67C23A; margin-right: 5px;"></i>CLIP模型</li>
                    <li><i class="el-icon-check" style="color: #67C23A; margin-right: 5px;"></i>聚类算法</li>
                    <li><i class="el-icon-check" style="color: #67C23A; margin-right: 5px;"></i>EXIF解析</li>
                  </ul>
                </div>
              </el-col>
            </el-row>
          </div>
        </el-col>
      </el-row>
      
      <!-- 核心功能展示 -->
      <el-divider style="margin: 40px 0;" />
      
      <el-row :gutter="20" style="margin-top: 20px">
        <el-col :xs="24" :sm="12" :md="8" :lg="6" v-for="(feature, index) in features" :key="index">
          <el-card shadow="hover" class="feature-card">
            <div slot="header" class="clearfix">
              <span><i :class="feature.icon" style="margin-right: 5px"></i>{{ feature.title }}</span>
            </div>
            <div class="feature-body">
              <p>{{ feature.description }}</p>
            </div>
          </el-card>
        </el-col>
      </el-row>
      
      <el-divider />
      
      <el-row :gutter="20">
        <el-col :xs="24" :sm="24" :md="12" :lg="12">
          <el-card class="update-log">
            <div slot="header" class="clearfix">
              <span>项目功能模块</span>
            </div>
            <el-collapse accordion>
              <el-collapse-item title="一、用户与权限管理模块">
                <ol>
                  <li>用户注册与登录系统</li>
                  <li>多层级的图片权限控制（私有、公开、仅链接、指定好友可见）</li>
                  <li>个人资料管理</li>
                  <li>好友系统与分享控制</li>
                </ol>
              </el-collapse-item>
              <el-collapse-item title="二、图片上传与存储模块">
                <ol>
                  <li>支持多种格式上传（JPEG、PNG、RAW等专业格式）</li>
                  <li>批量上传与进度显示</li>
                  <li>智能缩略图生成</li>
                  <li>EXIF信息自动提取与存储</li>
                </ol>
              </el-collapse-item>
              <el-collapse-item title="三、智能分类与标签识别模块">
                <ol>
                  <li>基于ResNet的内容识别（场景、人物、物体）</li>
                  <li>EXIF技术参数提取（设备、镜头、曝光参数）</li>
                  <li>风格与构图分析</li>
                  <li>多维度标签系统</li>
                </ol>
              </el-collapse-item>
              <el-collapse-item title="四、智能搜索与检索模块">
                <ol>
                  <li>关键词搜索</li>
                  <li>自然语言描述搜索</li>
                  <li>多标签组合筛选</li>
                  <li>高级搜索（设备、时间、参数等）</li>
                </ol>
              </el-collapse-item>
              <el-collapse-item title="五、图片聚类与自动相册模块">
                <ol>
                  <li>智能相似图片聚类</li>
                  <li>自动生成主题相册</li>
                  <li>时间线展示</li>
                  <li>地理位置分组</li>
                </ol>
              </el-collapse-item>
              <el-collapse-item title="六、图片论坛模块">
                <ol>
                  <li>器材讨论区</li>
                  <li>作品交流区</li>
                  <li>约拍专区</li>
                  <li>教程分享区</li>
                  <li>智能标签辅助分享</li>
                </ol>
              </el-collapse-item>
            </el-collapse>
          </el-card>
        </el-col>
        
        <el-col :xs="24" :sm="24" :md="12" :lg="12">
          <el-card class="update-log">
            <div slot="header" class="clearfix">
              <span>系统数据统计</span>
            </div>
            <div class="data-stats">
              <el-row :gutter="20">
                <el-col :span="12">
                  <div class="stat-item">
                    <div class="stat-icon" style="color: #409EFF;">
                      <i class="el-icon-picture" style="font-size: 24px;"></i>
                    </div>
                    <div class="stat-info">
                      <div class="stat-value">0</div>
                      <div class="stat-label">图片总数</div>
                    </div>
                  </div>
                </el-col>
                <el-col :span="12">
                  <div class="stat-item">
                    <div class="stat-icon" style="color: #67C23A;">
                      <i class="el-icon-collection-tag" style="font-size: 24px;"></i>
                    </div>
                    <div class="stat-info">
                      <div class="stat-value">0</div>
                      <div class="stat-label">智能标签</div>
                    </div>
                  </div>
                </el-col>
              </el-row>
              <el-row :gutter="20" style="margin-top: 20px;">
                <el-col :span="12">
                  <div class="stat-item">
                    <div class="stat-icon" style="color: #E6A23C;">
                      <i class="el-icon-folder" style="font-size: 24px;"></i>
                    </div>
                    <div class="stat-info">
                      <div class="stat-value">0</div>
                      <div class="stat-label">自动相册</div>
                    </div>
                  </div>
                </el-col>
                <el-col :span="12">
                  <div class="stat-item">
                    <div class="stat-icon" style="color: #F56C6C;">
                      <i class="el-icon-s-custom" style="font-size: 24px;"></i>
                    </div>
                    <div class="stat-info">
                      <div class="stat-value">1</div>
                      <div class="stat-label">当前用户</div>
                    </div>
                  </div>
                </el-col>
              </el-row>
            </div>
            
            <div style="margin-top: 30px;">
              <h4>系统特色</h4>
              <ul class="feature-list">
                <li><i class="el-icon-check" style="color: #67C23A;"></i> 支持专业RAW格式上传与预览</li>
                <li><i class="el-icon-check" style="color: #67C23A;"></i> 多维度智能标签系统</li>
                <li><i class="el-icon-check" style="color: #67C23A;"></i> 基于AI的相似图片聚类</li>
                <li><i class="el-icon-check" style="color: #67C23A;"></i> 灵活的权限管理体系</li>
                <li><i class="el-icon-check" style="color: #67C23A;"></i> 自然语言图片搜索</li>
              </ul>
            </div>
          </el-card>
        </el-col>
      </el-row>
      
      <el-row style="margin-top: 30px; text-align: center;">
        <el-col :span="24">
          <div style="color: #999; font-size: 14px;">
            <p>摄影作品智能管理与分类系统 © 2025 毕业设计项目</p>
            <p>答辩人：屈昭穗 | 指导老师：王旭 | 答辩时间：2025.12.6</p>
          </div>
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
      version: "1.0.0",
      // 用户头像
      userAvatar: "https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png",
      // 核心功能
      features: [
        {
          title: "智能分类",
          icon: "el-icon-c-scale-to-original",
          description: "基于AI的自动图片分类与标签识别"
        },
        {
          title: "高级搜索",
          icon: "el-icon-search",
          description: "支持关键词、自然语言等多种搜索方式"
        },
        {
          title: "权限管理",
          icon: "el-icon-lock",
          description: "多层次图片权限控制与安全分享"
        },
        {
          title: "RAW支持",
          icon: "el-icon-camera",
          description: "专业RAW格式上传、预览与管理"
        },
        {
          title: "自动聚类",
          icon: "el-icon-data-analysis",
          description: "相似图片智能聚类与自动相册生成"
        },
        {
          title: "摄影社区",
          icon: "el-icon-chat-line-square",
          description: "作品分享、器材讨论、约拍交流"
        }
      ]
    }
  },
  methods: {
    goTarget(path) {
      if (path.startsWith('http')) {
        window.open(path, "_blank")
      } else {
        this.$router.push(path)
      }
    }
  },
  mounted() {
    // 可以在这里获取系统统计数据
    // this.getSystemStats();
  }
}
</script>

<style scoped lang="scss">
.home {
  .main-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    height: 60px;
    padding: 0 20px;
    background: white;
    border-bottom: 1px solid #f0f0f0;
    box-shadow: 0 1px 4px rgba(0,0,0,0.05);
    position: sticky;
    top: 0;
    z-index: 1000;
    
    .header-left {
      display: flex;
      align-items: center;
      
      .logo {
        display: flex;
        align-items: center;
        margin-right: 40px;
        
        .logo-text {
          font-size: 24px;
          font-weight: 600;
          color: #333;
          letter-spacing: 1px;
        }
      }
      
      .nav-links {
        display: flex;
        gap: 30px;
        
        .nav-link {
          font-size: 16px;
          color: #666;
          cursor: pointer;
          transition: color 0.3s;
          padding: 5px 0;
          position: relative;
          
          &.active {
            color: #409EFF;
            font-weight: 500;
            
            &::after {
              content: '';
              position: absolute;
              bottom: -8px;
              left: 0;
              right: 0;
              height: 2px;
              background: #409EFF;
              border-radius: 1px;
            }
          }
          
          &:hover {
            color: #409EFF;
          }
        }
      }
    }
    
    .header-right {
      .user-avatar {
        display: flex;
        align-items: center;
        cursor: pointer;
        padding: 8px 12px;
        border-radius: 20px;
        transition: background-color 0.3s;
        
        &:hover {
          background-color: #f5f7fa;
        }
      }
    }
  }
  
  .main-content {
    padding: 30px 20px;
  }
  
  .main-title {
    font-size: 32px;
    font-weight: 600;
    color: #333;
    margin-bottom: 20px;
    line-height: 1.3;
  }
  
  .main-description {
    font-size: 16px;
    line-height: 1.8;
    color: #666;
    margin-bottom: 30px;
  }
  
  .system-info {
    margin-bottom: 30px;
    
    .info-label {
      font-weight: 500;
      color: #666;
    }
    
    .info-value {
      color: #409EFF;
      font-weight: 500;
    }
    
    .tags {
      margin-top: 15px;
    }
  }
  
  .action-buttons {
    margin-top: 30px;
  }
  
  .tech-architecture {
    .section-title {
      font-size: 24px;
      font-weight: 500;
      color: #333;
      margin: 0;
    }
    
    .tech-category {
      text-align: center;
      
      .tech-icon {
        width: 60px;
        height: 60px;
        border-radius: 12px;
        display: flex;
        align-items: center;
        justify-content: center;
        margin: 0 auto 15px;
        font-size: 28px;
      }
      
      h4 {
        font-size: 16px;
        font-weight: 500;
        color: #333;
        margin-bottom: 15px;
      }
      
      ul {
        padding: 0;
        margin: 0;
        
        li {
          list-style: none;
          font-size: 14px;
          color: #666;
          margin-bottom: 8px;
          text-align: left;
          padding-left: 20px;
        }
      }
    }
  }

  // 其余原有样式保持不变
  blockquote {
    padding: 10px 20px;
    margin: 0 0 20px;
    font-size: 17.5px;
    border-left: 5px solid #eee;
  }
  hr {
    margin-top: 20px;
    margin-bottom: 20px;
    border: 0;
    border-top: 1px solid #eee;
  }
  .col-item {
    margin-bottom: 20px;
  }

  ul {
    padding: 0;
    margin: 0;
  }

  font-family: "open sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
  font-size: 13px;
  color: #676a6c;
  overflow-x: hidden;

  ul {
    list-style-type: none;
  }

  h4 {
    margin-top: 0px;
  }

  h2 {
    margin-top: 10px;
    font-size: 26px;
    font-weight: 100;
  }

  p {
    margin-top: 10px;
    line-height: 1.6;

    b {
      font-weight: 700;
    }
  }

  .update-log {
    ol {
      display: block;
      list-style-type: decimal;
      margin-block-start: 1em;
      margin-block-end: 1em;
      margin-inline-start: 0;
      margin-inline-end: 0;
      padding-inline-start: 40px;
      li {
        margin-bottom: 5px;
      }
    }
  }
  
  .feature-card {
    height: 160px;
    margin-bottom: 20px;
    transition: all 0.3s;
    
    &:hover {
      transform: translateY(-5px);
      box-shadow: 0 6px 18px rgba(0,0,0,0.1);
    }
    
    .feature-body {
      font-size: 12px;
      color: #666;
      line-height: 1.5;
    }
  }
  
  .data-stats {
    .stat-item {
      display: flex;
      align-items: center;
      padding: 15px;
      background: #f8f9fa;
      border-radius: 8px;
      
      .stat-icon {
        margin-right: 15px;
        width: 50px;
        height: 50px;
        display: flex;
        align-items: center;
        justify-content: center;
        background: rgba(64, 158, 255, 0.1);
        border-radius: 8px;
      }
      
      .stat-info {
        .stat-value {
          font-size: 24px;
          font-weight: bold;
          color: #333;
        }
        
        .stat-label {
          font-size: 12px;
          color: #666;
          margin-top: 5px;
        }
      }
    }
  }
  
  .feature-list {
    li {
      padding: 8px 0;
      border-bottom: 1px dashed #eee;
      
      &:last-child {
        border-bottom: none;
      }
      
      i {
        margin-right: 8px;
      }
    }
  }
}
</style>