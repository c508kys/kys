<template>
  <div class="app">
    <!-- 高级背景特效 -->
    <div class="background-effects">
      <div class="grid-bg"></div>
      <div class="floating-particles" ref="floatingParticles"></div>
      <div class="dynamic-lines" ref="dynamicLines"></div>
      <div id="code-elements" ref="codeElements"></div>
    </div>

    <!-- 导航栏 -->
    <header>
      <div class="container">
        <nav>
        <div class="logo">
        <img src="/src//assets/image.png" alt="河北北方学院信息科学与工程学院 logo" style="height: 40px; margin-right: 10px;">
      </div>
          
          <ul class="nav-links">
            <li><a href="#home" @click.prevent="scrollTo('home')">首页</a></li>
            <li><a href="#about" @click.prevent="scrollTo('about')">关于我们</a></li>
            <li><a href="#groups" @click.prevent="scrollTo('groups')">研究组</a></li>
            <li><a href="#platform" @click.prevent="scrollTo('platform')">信息平台</a></li>
            <li><a href="#member" @click.prevent="scrollTo('member')">成员专区</a></li>
            <li><a href="#join" @click.prevent="scrollTo('join')">加入我们</a></li>
          </ul>
          <button class="mobile-menu-btn" @click="toggleMobileMenu">
            <i class="fas fa-bars"></i>
          </button>
        </nav>
      </div>
    </header>

    <!-- 移动端菜单 -->
    <div class="mobile-menu" :class="{ 'active': mobileMenuOpen }">
      <ul>
        <li><a href="#home" @click.prevent="scrollTo('home')">首页</a></li>
        <li><a href="#about" @click.prevent="scrollTo('about')">关于我们</a></li>
        <li><a href="#groups" @click.prevent="scrollTo('groups')">研究组</a></li>
        <li><a href="#platform" @click.prevent="scrollTo('platform')">信息平台</a></li>
        <li><a href="#member" @click.prevent="scrollTo('member')">成员专区</a></li>
        <li><a href="#join" @click.prevent="scrollTo('join')">加入我们</a></li>
      </ul>
    </div>

    <!-- 英雄区域 -->
    <section class="hero" id="home">
      <div class="container">
        <h1>移动应用技术开发俱乐部(C508科研室)</h1>
        <p>移动应用技术开发俱乐部致力于移动开发技术、移动前端交互和机器学习的研究，为学生提供优质的科研环境和实践机会</p>
        <a href="#join" class="btn" @click.prevent="scrollTo('join')">立即加入</a>
      </div>
    </section>

    <!-- 科研室内具体展示 -->
    <section class="lab-showcase" id="about">
      <div class="container">
        <h2 class="section-title">科研室内景展示</h2>
        <div class="showcase-container">
          <div class="video-container">
            <div class="video-wrapper">
              <video controls poster="/src/components/HelloWorld.vue">
                <source src="/src/components/HelloWorld.vue" type="video/mp4">
                您的浏览器不支持HTML5视频
              </video>
              <div class="video-caption">科研室环境与日常工作</div>
            </div>
          </div>
          <div class="image-slider">
            <div class="slider-container" @mouseenter="pauseSlider" @mouseleave="resumeSlider">
              <div class="slider-track" :style="{ transform: `translateX(-${currentSlide * 100}%)` }">
                <div class="slide" v-for="(slide, index) in slides" :key="index" :class="{ 'active': index === currentSlide }">
                  <img :src="slide.image" :alt="slide.alt">
                  <div class="slide-caption">{{ slide.caption }}</div>
                </div>
              </div>
              <div class="slider-nav">
                <button class="prev-btn" @click="prevSlide">&lt;</button>
                <div class="dots">
                  <span class="dot" v-for="(slide, index) in slides" :key="index" 
                        :class="{ 'active': index === currentSlide }"
                        @click="goToSlide(index)"></span>
                </div>
                <button class="next-btn" @click="nextSlide">&gt;</button>
              </div>
            </div>
          </div>
        </div>
        <!-- 重要信息 -->
        <div class="notice-board-wrapper">
  <div class="notice-board-container">
    <div class="notice-board">
      <div class="notice" 
           v-for="(notice, index) in notices" 
           :key="index" 
           @click="openModal(notice)"
           :class="{ 'active': activeNotice === notice }">
        <h3>{{ notice.title }}</h3>
        <p v-html="notice.shortContent || notice.content"></p>
        <div class="notice-date">{{ notice.date }}</div>
      </div>
      <!-- 复制一份用于无缝循环 -->
      <div class="notice" 
           v-for="(notice, index) in notices" 
           :key="'copy-'+index" 
           @click="openModal(notice)"
           :class="{ 'active': activeNotice === notice }">
        <h3>{{ notice.title }}</h3>
        <p v-html="notice.shortContent || notice.content"></p>
        <div class="notice-date">{{ notice.date }}</div>
      </div>
    </div>
  </div>
  
  <!-- 模态框 -->
  <div class="notice-modal" v-if="activeNotice" @click.self="closeModal">
    <div class="modal-content">
      <button class="close-btn" @click="closeModal">&times;</button>
      <h2>{{ activeNotice.title }}</h2>
      <div class="modal-body" v-html="activeNotice.content"></div>
      <div class="notice-date">{{ activeNotice.date }}</div>
    </div>
  </div>
</div>
      </div>
    </section>

    <!-- 研究组展示 -->
    <section class="research-groups" id="groups">
      <div class="container">
        <h2 class="section-title">我们的研究组</h2>
        <div class="groups-container">
          <div class="group-card" v-for="(group, index) in researchGroups" :key="index">
            <div class="group-img">{{ group.name }}</div>
            <div class="group-content">
              <h3>{{ group.name }}</h3>
              <p>{{ group.description }}</p>
              <a :href="group.link" class="btn" style="display: inline-block; margin-top: 15px;">了解更多</a>
            </div>
          </div>
        </div>
      </div>
    </section>

    <!-- 科研室信息平台 -->
    <section class="lab-platform" id="platform">
      <div class="container">
        <h2 class="section-title">科研室信息平台</h2>
        <p style="max-width: 800px; margin: 0 auto 50px; text-align: center; color: var(--text-color);">
          点击下方模块了解更多关于我们科研室的详细信息
        </p>
        <div class="platform-container">
          <div class="platform-card" v-for="(platform, index) in platforms" :key="index">
            <div class="platform-header">
              <h3>{{ platform.title }}</h3>
            </div>
            <div class="platform-content">
              <div class="platform-icon">
                <i :class="platform.icon"></i>
              </div>
              <p>{{ platform.description }}</p>
              <a :href="platform.link" class="btn">查看详情</a>
            </div>
          </div>
        </div>
      </div>
    </section>

    <!-- 成员专区 -->
    <section class="member-area" id="member">
      <div class="container">
        <h2 class="section-title">成员专区</h2>
        <p style="max-width: 800px; margin: 0 auto 50px; text-align: center; color: var(--text-color);">
          科研室成员专属功能，请登录后使用
        </p>
        <div class="member-features">
          <div class="feature-card" v-for="(feature, index) in memberFeatures" :key="index">
            <div class="feature-icon">
              <i :class="feature.icon"></i>
            </div>
            <h3>{{ feature.title }}</h3>
            <p>{{ feature.description }}</p>
            <a :href="feature.link" class="btn">进入</a>
          </div>
        </div>
      </div>
    </section>

    <!-- 加入我们 -->
    <section class="join-us" id="join">
      <div class="container">
        <h2 class="section-title">加入移动应用开发俱乐部</h2>
        <p style="max-width: 800px; margin: 0 auto 30px; color: var(--text-color);">
          我们正在寻找对科研充满热情的学生加入我们的团队。只要你有兴趣，我们都欢迎你的加入！
        </p>
        <form id="join-form" @submit.prevent="submitForm">
          <div class="form-group">
            <label for="name">姓名</label>
            <input type="text" id="name" name="name" v-model="formData.name" required>
          </div>
          <div class="form-group">
            <label for="student-id">学号</label>
            <input type="text" id="student-id" name="student-id" v-model="formData.studentId" required>
          </div>
          <div class="form-group">
            <label for="major">专业</label>
            <input type="text" id="major" name="major" v-model="formData.major" required>
          </div>
          <div class="form-group">
            <label for="email">邮箱</label>
            <input type="email" id="email" name="email" v-model="formData.email" required>
          </div>
          <div class="form-group">
            <label for="phone">联系电话</label>
            <input type="tel" id="phone" name="phone" v-model="formData.phone" required>
          </div>
          <div class="form-group">
            <label for="group">意向组别</label>
            <select id="group" name="group" v-model="formData.group" required>
              <option value="">请选择...</option>
              <option value="mobile">移动开发技术组</option>
              <option value="frontend">移动前端交互组</option>
              <option value="ml">机器学习组</option>
            </select>
          </div>
          <div class="form-group">
            <label for="skills">相关技能</label>
            <input type="text" id="skills" name="skills" v-model="formData.skills" placeholder="例如: Python编程, 机器学习基础等">
          </div>
          <div class="form-group">
            <label for="message">个人陈述</label>
            <textarea id="message" name="message" v-model="formData.message" required 
                      placeholder="请简要说明你为什么想加入我们科研室，以及你的相关经验..."></textarea>
          </div>
          <button type="submit" class="btn" style="width: 100%;">提交申请</button>
        </form>
      </div>
    </section>

    <!-- 页脚 -->
    <footer>
      <div class="container footer-content">
        <h3>移动应用开发俱乐部</h3>
        <p>河北北方学院信息科学与工程学院</p>
        <ul class="footer-links">
          <li><a href="#home" @click.prevent="scrollTo('home')">首页</a></li>
          <li><a href="#about" @click.prevent="scrollTo('about')">关于我们</a></li>
          <li><a href="#groups" @click.prevent="scrollTo('groups')">研究组</a></li>
          <li><a href="#platform" @click.prevent="scrollTo('platform')">信息平台</a></li>
          <li><a href="#member" @click.prevent="scrollTo('member')">成员专区</a></li>
          <li><a href="#join" @click.prevent="scrollTo('join')">加入我们</a></li>
        </ul>
        <p class="copyright">© 2025 移动应用开发俱乐部 版权所有</p>
      </div>
    </footer>
  </div>
</template>

<script>
export default {

  name: 'App',
  data() {
    return {
      mobileMenuOpen: false,
      currentSlide: 0,
      slideInterval: null,
      slides: [
        {
          image: 'images/lab-image1.jpg',
          alt: '科研室活动1',
          caption: '学术讨论会'
        },
        {
          image: 'images/lab-image2.jpg',
          alt: '科研室活动2',
          caption: '项目开发中'
        },
        {
          image: 'images/lab-image3.jpg',
          alt: '科研室活动3',
          caption: '成果展示'
        }
      ],
      notices: [
        {
          title: '考核成绩公布',
          content: '2025年新生面试成绩已出，请关注各部门群聊通知',
          date: '2025-11-15',
          link: 'exam-results.html'
        },
        {
          title: '考核成绩公布',
          content: '2025年新生面试成绩已出，请关注各部门群聊通知',
          date: '2025-11-15',
          link: 'exam-results.html'
        },
        {
          title: '考核成绩公布',
          content: '2025年新生面试成绩已出，请关注各部门群聊通知',
          date: '2025-11-15',
          link: 'exam-results.html'
        },
        {
          title: '考察期通知',
          content: '新成员考察期至12月底，请按时完成分配任务',
          date: '2025-11-15',
          link: 'probation-notice.html'
        },
        {
          title: '近期重要事件',
          content: '12月5日：人工智能学术研讨会<br>12月15日：项目中期检查',
          date: '2025-11-10',
          link: 'upcoming-events.html'
        }
      ],
      researchGroups: [
        {
          name: '移动开发技术组',
          description: '专注于移动应用开发、用户体验设计和跨平台技术的研究与应用开发。培养学生在移动开发领域的理论知识和实践能力。',
          link: 'mobile-group.html'
        },
        {
          name: '移动前端交互组',
          description: '专注于移动端用户界面设计、用户体验优化和前端技术的研究与应用开发。培养学生在移动前端领域的理论知识和实践能力。',
          link: 'mobile-frontend-group.html'
        },
        {
          name: '机器学习组',
          description: '专注于深度学习、自然语言处理和计算机视觉等领域的研究与应用开发。培养学生在机器学习领域的理论知识和实践能力。',
          link: 'ml-group.html'
        }
      ],
      platforms: [
        {
          title: '科研成果展示',
          icon: 'fas fa-trophy',
          description: '查看我们科研室近年来的重要科研成果、发表论文和获奖情况',
          link: 'achievements.html'
        },
        {
          title: '师资团队',
          icon: 'fas fa-user-tie',
          description: '了解我们优秀的指导老师团队和他们的研究方向',
          link: 'faculty.html'
        },
        {
          title: '优秀校友',
          icon: 'fas fa-graduation-cap',
          description: '了解从我们科研室毕业的优秀学长学姐的发展情况',
          link: 'alumni.html'
        },
        {
          title: 'AI智能问询',
          icon: 'fas fa-robot',
          description: '使用AI助手快速获取科研室相关信息、常见问题解答与智能推荐',
          link: 'ai-assistant.html'
        },
        
      ],
      memberFeatures: [
        {
          title: '个人信息管理',
          icon: 'fas fa-user',
          description: '维护个人资料 设置查看权限',
          link: 'member-info.html'
        },
        {
          title: '值日表',
          icon: 'fas fa-calendar-alt',
          description: '查看和调整值日安排',
          link: 'duty-schedule.html'
        },
        {
          title: '任务管理',
          icon: 'fas fa-tasks',
          description: '分配和跟踪科研任务',
          link: 'tasks.html'
        },
        {
          title: '反馈建议',
          icon: 'fas fa-comments',
          description: '提交和管理意见建议',
          link: 'feedback.html'
        }
      ],
      formData: {
        name: '',
        studentId: '',
        major: '',
        email: '',
        phone: '',
        group: '',
        skills: '',
        message: ''
      }
    }
  },
  mounted() {
    this.createFloatingParticles();
    this.createDynamicLines();
    this.createCodeElements();
    this.startSlider();
    this.loadNoticeContent();
     this.startAutoScroll();
    window.addEventListener('resize', this.handleResize);
  },
  
  beforeDestroy() {
    clearInterval(this.slideInterval);
    window.removeEventListener('resize', this.handleResize);
    this.stopAutoScroll();
  },
  methods: {
    toggleMobileMenu() {
      this.mobileMenuOpen = !this.mobileMenuOpen;
    },
    
    // 重要消息
    openModal(notice) {
    this.activeNotice = notice;
    document.body.style.overflow = 'hidden';
    this.stopAutoScroll();
  },
  closeModal() {
    this.activeNotice = null;
    document.body.style.overflow = '';
    this.startAutoScroll();
  },
  startAutoScroll() {
    const board = this.$el.querySelector('.notice-board');
    if (!board) return;
    
    let scrollAmount = 0;
    const cardWidth = 320; // 300px宽度 + 20px间隙
    
    this.scrollInterval = setInterval(() => {
      scrollAmount += 1;
      
      // 当滚动到复制的内容开始时，重置到原始位置
      if (scrollAmount >= cardWidth * this.notices.length) {
        scrollAmount = 0;
        board.scrollLeft = 0;
      } else {
        board.scrollLeft = scrollAmount;
      }
    }, 30); // 调整这个值可以改变滚动速度
  },
  stopAutoScroll() {
    if (this.scrollInterval) {
      clearInterval(this.scrollInterval);
      this.scrollInterval = null;
    }
  },
  // 消息
    openModal(notice) {
    this.activeNotice = notice;
    document.body.style.overflow = 'hidden'; // 防止背景滚动
  },
  closeModal() {
    this.activeNotice = null;
    document.body.style.overflow = '';
  },
    startSlider() {
      this.slideInterval = setInterval(this.nextSlide, 5000);
    },
    pauseSlider() {
      clearInterval(this.slideInterval);
    },
    resumeSlider() {
      this.slideInterval = setInterval(this.nextSlide, 5000);
    },
    nextSlide() {
      this.currentSlide = (this.currentSlide + 1) % this.slides.length;
    },
    prevSlide() {
      this.currentSlide = (this.currentSlide - 1 + this.slides.length) % this.slides.length;
    },
    goToSlide(index) {
      this.currentSlide = index;
    },
    goToNotice(link) {
      window.location.href = link;
    },
    submitForm() {
      console.log('表单提交:', this.formData);
      alert('感谢您的申请！我们会尽快与您联系。');
      
      // 重置表单
      this.formData = {
        name: '',
        studentId: '',
        major: '',
        email: '',
        phone: '',
        group: '',
        skills: '',
        message: ''
      };
    },
    loadNoticeContent() {
      // 可以从localStorage或API加载公告内容
      // 这里使用data中的默认值
    },
    createFloatingParticles() {
      const container = this.$refs.floatingParticles;
      const particleCount = 25;

      for (let i = 0; i < particleCount; i++) {
        const particle = document.createElement('div');
        particle.classList.add('particle');

        // 随机大小 (3px - 10px)
        const size = Math.random() * 7 + 3;
        particle.style.width = `${size}px`;
        particle.style.height = `${size}px`;

        // 随机位置
        particle.style.left = `${Math.random() * 100}%`;
        particle.style.top = `${Math.random() * 100}%`;

        // 随机动画延迟和持续时间
        particle.style.animationDelay = `${Math.random() * 5}s`;
        particle.style.animationDuration = `${Math.random() * 10 + 10}s`;

        // 随机颜色变化
        const hue = 200 + Math.random() * 40;
        particle.style.backgroundColor = `hsla(${hue}, 80%, 60%, ${Math.random() * 0.4 + 0.2})`;

        container.appendChild(particle);
      }
    },
    createDynamicLines() {
      const container = this.$refs.dynamicLines;
      const lineCount = 8;

      for (let i = 0; i < lineCount; i++) {
        const line = document.createElement('div');
        line.classList.add('line');

        // 随机长度和位置
        const length = Math.random() * 300 + 100;
        line.style.width = `${length}px`;
        line.style.top = `${Math.random() * 100}%`;
        line.style.left = `${Math.random() * 100}%`;

        // 随机旋转角度
        const angle = Math.random() * 360;
        line.style.transform = `rotate(${angle}deg)`;

        // 随机动画延迟和持续时间
        line.style.animationDelay = `${Math.random() * 5}s`;
        line.style.animationDuration = `${Math.random() * 15 + 10}s`;

        // 随机透明度
        line.style.opacity = Math.random() * 0.3 + 0.2;

        container.appendChild(line);
      }
    },
    createCodeElements() {
      const container = this.$refs.codeElements;
      const codeSnippets = [
        "function research() { ... }",
        "const data = analyze();",
        "import tensorflow as tf",
        "class NeuralNetwork: ...",
        "SELECT * FROM research_data",
        "def train_model(): ...",
        "npm install research-package",
        "git commit -m 'research update'",
        "while(experiment) { ... }",
        "public void analyzeData()"
      ];

      for (let i = 0; i < 15; i++) {
        const codeElement = document.createElement('div');
        codeElement.classList.add('code-element');
        codeElement.textContent = codeSnippets[Math.floor(Math.random() * codeSnippets.length)];

        // 随机位置
        codeElement.style.left = `${Math.random() * 100}%`;
        codeElement.style.top = `${Math.random() * 100}%`;

        // 随机动画延迟和持续时间
        codeElement.style.animationDelay = `${Math.random() * 10}s`;
        codeElement.style.animationDuration = `${Math.random() * 10 + 5}s`;

        // 随机字体大小
        codeElement.style.fontSize = `${Math.random() * 6 + 10}px`;

        container.appendChild(codeElement);
      }
    },
    handleResize() {
      // 响应式布局调整逻辑
    }
  }
}
</script>

<style>
/* 基础蓝白科技感配色方案 */
:root {
  --primary-color: #1e88e5;
  --secondary-color: #42a5f5;
  --light-color: #e3f2fd;
  --dark-color: #0d47a1;
  --text-color: #333;
  --white: #fff;
}

* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: 'Helvetica Neue', Arial, sans-serif;
}
.logo {
  display: flex;
  align-items: center; /* 让图片和文字垂直居中对齐 */
  font-size: 24px;
  font-weight: bold;
  color: var(--primary-color);
}

body {
  color: var(--text-color);
  line-height: 1.6;
  background-color: var(--white);
  overflow-x: hidden;
  width: 100%;
}

/* 关键修改：移除最大宽度限制，让内容与背景同宽 */
.container {
  width: 100%;
  padding: 0 20px;
}

/* ==================== 背景特效容器 ==================== */
.background-effects {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: -1;
  overflow: hidden;
}

/* ==================== 网格背景动画 ==================== */
.grid-bg {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background:
    linear-gradient(rgba(30, 136, 229, 0.1) 1px, transparent 1px),
    linear-gradient(90deg, rgba(30, 136, 229, 0.1) 1px, transparent 1px);
  background-size: 40px 40px;
  animation: gridMove 20s linear infinite;
}

/* ==================== 浮动粒子 ==================== */
.floating-particles {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  pointer-events: none;
}

.particle {
  position: absolute;
  background-color: var(--primary-color);
  border-radius: 50%;
  opacity: 0.3;
  animation: float 12s infinite ease-in-out;
  filter: blur(1px);
}

/* ==================== 动态线条 ==================== */
.dynamic-lines {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  overflow: hidden;
  pointer-events: none;
}

.line {
  position: absolute;
  background: linear-gradient(to right, rgba(30, 136, 229, 0.5), transparent);
  height: 1px;
  animation: lineFlow 15s infinite linear;
}

/* ==================== 代码元素样式 ==================== */
.code-element {
  position: absolute;
  font-family: 'Courier New', monospace;
  font-size: 12px;
  color: rgba(30, 136, 229, 0.6);
  opacity: 0;
  animation: codeFade 8s infinite;
  pointer-events: none;
}

/* 导航栏样式 */
header {
  background-color: rgba(255, 255, 255, 0.9);
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
  position: sticky;
  top: 0;
  z-index: 100;
  backdrop-filter: blur(5px);
  width: 100%;
}

nav {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 15px 0;
}

.logo {
  font-size: 24px;
  font-weight: bold;
  color: var(--primary-color);
  display: flex;
  align-items: center;
}

.logo::before {
  content: "";
  display: inline-block;
  width: 10px;
  height: 10px;
  background-color: var(--primary-color);
  margin-right: 10px;
  border-radius: 50%;
  animation: techPulse 2s infinite;
}

.nav-links {
  display: flex;
  list-style: none;
}

.nav-links li {
  margin-left: 30px;
  position: relative;
}

.nav-links a {
  text-decoration: none;
  color: var(--text-color);
  font-weight: 500;
  transition: color 0.3s;
  padding: 5px 0;
}

.nav-links a::after {
  content: "";
  position: absolute;
  bottom: 0;
  left: 0;
  width: 0;
  height: 2px;
  background-color: var(--primary-color);
  transition: width 0.3s;
}

.nav-links a:hover::after {
  width: 100%;
}

.nav-links a:hover {
  color: var(--primary-color);
}

.mobile-menu-btn {
  display: none;
  background: none;
  border: none;
  color: var(--primary-color);
  font-size: 24px;
  cursor: pointer;
}

.mobile-menu {
  display: none;
  position: fixed;
  top: 70px;
  left: 0;
  width: 100%;
  background-color: rgba(255, 255, 255, 0.95);
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
  z-index: 99;
  transform: translateY(-100%);
  transition: transform 0.3s ease;
  backdrop-filter: blur(5px);
}

.mobile-menu.active {
  transform: translateY(0);
}

.mobile-menu ul {
  list-style: none;
  padding: 20px;
}

.mobile-menu li {
  margin-bottom: 15px;
}

.mobile-menu a {
  text-decoration: none;
  color: var(--text-color);
  font-weight: 500;
  display: block;
  padding: 10px;
  transition: color 0.3s;
}

.mobile-menu a:hover {
  color: var(--primary-color);
}

/* 英雄区域 */
.hero {
  padding: 150px 0 100px;
  text-align: center;
  position: relative;
  overflow: hidden;
  width: 100%;
}

.hero::before {
  content: "";
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: radial-gradient(circle at center, rgba(30, 136, 229, 0.1) 0%, transparent 70%);
  pointer-events: none;
  z-index: -1;
}

.hero h1 {
  font-size: 3rem;
  margin-bottom: 20px;
  color: var(--dark-color);
  position: relative;
  display: inline-block;
  text-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
}

.hero h1::after {
  content: "";
  position: absolute;
  left: 0;
  bottom: -10px;
  width: 100%;
  height: 3px;
  background: linear-gradient(90deg, var(--primary-color), var(--secondary-color), var(--primary-color));
  background-size: 200% 100%;
  animation: gradientFlow 3s ease infinite;
}

.hero p {
  font-size: 1.2rem;
  max-width: 800px;
  margin: 0 auto 30px;
  color: var(--text-color);
}

/* 按钮样式 */
.btn {
  display: inline-block;
  background: linear-gradient(135deg, var(--primary-color), var(--secondary-color));
  color: var(--white);
  padding: 12px 30px;
  border-radius: 30px;
  text-decoration: none;
  font-weight: 500;
  transition: all 0.3s;
  position: relative;
  overflow: hidden;
  border: none;
  cursor: pointer;
  box-shadow: 0 4px 15px rgba(30, 136, 229, 0.3);
  z-index: 1;
}

.btn:hover {
  transform: translateY(-3px);
  box-shadow: 0 10px 20px rgba(30, 136, 229, 0.4);
}

.btn::after {
  content: "";
  display: block;
  position: absolute;
  left: -100%;
  top: 0;
  width: 100%;
  height: 100%;
  background: linear-gradient(90deg, transparent, rgba(255, 255, 255, 0.4), transparent);
  transition: all 0.5s;
  z-index: -1;
}

.btn:hover::after {
  left: 100%;
}

/* 科研室内具体展示 */
.lab-showcase {
  padding: 100px 0;
  background-color: var(--white);
  position: relative;
  width: 100%;
}

.showcase-container {
  display: flex;
  gap: 30px;
  margin-bottom: 40px;
}

.video-container {
  flex: 1;
}

.video-wrapper {
  position: relative;
  border-radius: 10px;
  overflow: hidden;
  box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
}

.video-wrapper video {
  width: 100%;
  display: block;
}

.video-caption {
  padding: 15px;
  background-color: rgba(0, 0, 0, 0.7);
  color: white;
  text-align: center;
  font-size: 0.9rem;
}

.image-slider {
  flex: 1;
}

.slider-container {
  position: relative;
  height: 100%;
  border-radius: 10px;
  overflow: hidden;
  box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
}

.slider-track {
  display: flex;
  height: 100%;
  transition: transform 0.5s ease;
}

.slide {
  min-width: 100%;
  position: relative;
}

.slide img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.slide-caption {
  position: absolute;
  bottom: 0;
  left: 0;
  right: 0;
  padding: 15px;
  background-color: rgba(0, 0, 0, 0.7);
  color: white;
  text-align: center;
}

.slider-nav {
  position: absolute;
  bottom: 10px;
  left: 0;
  right: 0;
  display: flex;
  justify-content: center;
  align-items: center;
  gap: 20px;
}

.slider-nav button {
  background: rgba(255, 255, 255, 0.7);
  border: none;
  width: 30px;
  height: 30px;
  border-radius: 50%;
  cursor: pointer;
  font-weight: bold;
  transition: all 0.3s;
}

.slider-nav button:hover {
  background: var(--primary-color);
  color: white;
}

.dots {
  display: flex;
  gap: 10px;
}

.dot {
  width: 10px;
  height: 10px;
  border-radius: 50%;
  background: rgba(255, 255, 255, 0.5);
  cursor: pointer;
}

.dot.active {
  background: var(--primary-color);
}

/* 公告板容器样式 */
.notice-board-wrapper {
  width: 100%;
  display: flex;
  justify-content: center;
  margin: 0 auto;
  position: relative;
  overflow: hidden;
}

.notice-board-container {
  width: 100%;
  max-width: 1200px;
  position: relative;
  padding: 0 20px;
  box-sizing: border-box;
}

/* 公告板主体样式 - 隐藏滚动条 */
.notice-board {
  display: flex;
  gap: 20px;
  padding: 20px 0;
  width: 100%;
  overflow: hidden;
  scroll-behavior: smooth;
}

/* 隐藏所有滚动条 */
.notice-board::-webkit-scrollbar {
  display: none;
}

.notice-board {
  -ms-overflow-style: none;
  scrollbar-width: none;
}

/* 单个公告卡片样式 */
.notice {
  flex: 0 0 300px;
  background: var(--light-color);
  padding: 20px;
  border-radius: 10px;
  box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
  position: relative;
  border-left: 4px solid var(--primary-color);
  transition: all 0.3s ease;
  cursor: pointer;
}

.notice:hover {
  transform: translateY(-5px);
  box-shadow: 0 10px 25px rgba(0, 0, 0, 0.15);
}

.notice h3 {
  color: var(--primary-color);
  margin-bottom: 10px;
  font-size: 1.2rem;
}

.notice p {
  margin-bottom: 10px;
  line-height: 1.5;
  display: -webkit-box;
  -webkit-line-clamp: 3;
  -webkit-box-orient: vertical;
  overflow: hidden;
}

.notice-date {
  font-size: 0.8rem;
  color: #666;
  text-align: right;
}

/* 模态框样式 */
.notice-modal {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background: rgba(0, 0, 0, 0.5);
  display: flex;
  align-items: center;
  justify-content: center;
  z-index: 1000;
  animation: fadeIn 0.3s;
}

.modal-content {
  background: white;
  width: 80%;
  max-width: 800px;
  max-height: 80vh;
  padding: 30px;
  border-radius: 10px;
  box-shadow: 0 5px 30px rgba(0, 0, 0, 0.3);
  position: relative;
  overflow-y: auto;
  animation: slideUp 0.3s;
  box-sizing: border-box;
}

.modal-content h2 {
  color: var(--primary-color);
  margin-bottom: 20px;
  font-size: 1.5rem;
}

.modal-body {
  line-height: 1.6;
  margin-bottom: 20px;
}

.close-btn {
  position: absolute;
  top: 15px;
  right: 15px;
  font-size: 24px;
  background: none;
  border: none;
  cursor: pointer;
  color: #666;
  padding: 5px;
  line-height: 1;
}

.close-btn:hover {
  color: #333;
}

/* 动画效果 */
@keyframes fadeIn {
  from { opacity: 0; }
  to { opacity: 1; }
}

@keyframes slideUp {
  from { 
    opacity: 0;
    transform: translateY(20px);
  }
  to { 
    opacity: 1;
    transform: translateY(0);
  }
}

/* 响应式设计 */
@media (max-width: 768px) {
  .notice-board-container {
    padding: 0 15px;
  }
  
  .notice {
    flex: 0 0 85%;
    padding: 15px;
  }
  
  .modal-content {
    width: 95%;
    padding: 20px;
  }
}

@media (max-width: 480px) {
  .notice {
    flex: 0 0 90%;
  }
  
  .modal-content {
    width: 98%;
    padding: 15px;
  }
}
/* 研究组展示 */
.research-groups {
  padding: 100px 0;
  background-color: var(--white);
  position: relative;
  width: 100%;
}

.research-groups::before {
  content: "";
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: url('data:image/svg+xml;utf8,<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 100 100" preserveAspectRatio="none"><path d="M0,0 L100,0 L100,100 L0,100 Z" fill="none" stroke="%231e88e5" stroke-width="0.5" stroke-dasharray="5,5" /></svg>');
  opacity: 0.05;
  pointer-events: none;
}

.section-title {
  text-align: center;
  margin-bottom: 50px;
  color: var(--dark-color);
  position: relative;
  display: inline-block;
  left: 50%;
  transform: translateX(-50%);
  font-size: 2.2rem;
}

.section-title::after {
  content: "";
  position: absolute;
  left: 0;
  bottom: -10px;
  width: 100%;
  height: 3px;
  background: linear-gradient(90deg, var(--primary-color), var(--secondary-color), var(--primary-color));
  background-size: 200% 100%;
  animation: gradientFlow 3s ease infinite;
}

.groups-container {
  display: flex;
  justify-content: space-between;
  flex-wrap: wrap;
  gap: 30px;
}

.group-card {
  flex: 1 1 300px;
  background-color: rgba(255, 255, 255, 0.9);
  border-radius: 10px;
  box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
  overflow: hidden;
  transition: all 0.5s ease;
  perspective: 1000px;
  transform-style: preserve-3d;
  backdrop-filter: blur(5px);
  border: 1px solid rgba(30, 136, 229, 0.1);
  position: relative;
  z-index: 1;
}

.group-card:hover {
  transform: translateY(-10px) rotateX(5deg) rotateY(5deg);
  box-shadow: 0 15px 40px rgba(0, 0, 0, 0.2);
}

.group-img {
  height: 200px;
  background: linear-gradient(135deg, var(--primary-color), var(--secondary-color));
  display: flex;
  align-items: center;
  justify-content: center;
  color: var(--white);
  font-size: 24px;
  font-weight: bold;
  transition: all 0.5s ease;
  position: relative;
  overflow: hidden;
}

.group-img::before {
  content: "";
  position: absolute;
  top: -50%;
  left: -50%;
  width: 200%;
  height: 200%;
  background: linear-gradient(
    to bottom right,
    rgba(255, 255, 255, 0.3) 0%,
    rgba(255, 255, 255, 0) 60%
  );
  transform: rotate(30deg);
  animation: shine 3s infinite;
}

.group-card:hover .group-img {
  transform: translateZ(20px);
}

.group-content {
  padding: 25px;
  position: relative;
}

.group-content h3 {
  margin-bottom: 15px;
  color: var(--primary-color);
  font-size: 1.4rem;
}

.group-content p {
  margin-bottom: 20px;
  color: var(--text-color);
}

.lab-platform {
  padding: 100px 20px;
  background-color: var(--light-color);
  position: relative;
  width: 100%;
}

.lab-platform::before {
  content: "";
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: url('data:image/svg+xml;utf8,<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 100 100" preserveAspectRatio="none"><path d="M0,0 L100,0 L100,100 L0,100 Z" fill="none" stroke="%231e88e5" stroke-width="0.5" stroke-dasharray="5,5" /></svg>');
  opacity: 0.05;
  pointer-events: none;
}

.platform-container {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
  gap: 30px;
  max-width: 1200px;
  min-width: auto;
  margin: 0 auto;
}

.platform-card {
  background: var(--white);
  border-radius: 10px;
  overflow: hidden;
  box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
  transition: all 0.3s ease;
  display: flex;
  flex-direction: column;
  position: relative;
  perspective: 1000px;
  transform-style: preserve-3d;
}

.platform-card:hover {
  transform: translateY(-8px) rotateX(5deg) rotateY(5deg);
  box-shadow: 0 15px 40px rgba(0, 0, 0, 0.15);
}

.platform-header {
  background: linear-gradient(135deg, var(--primary-color), var(--secondary-color));
  color: white;
  padding: 20px;
  text-align: center;
  position: relative;
  overflow: hidden;
}

.platform-header::before {
  content: "";
  position: absolute;
  top: -50%;
  left: -50%;
  width: 200%;
  height: 200%;
  background: linear-gradient(
    to bottom right,
    rgba(255, 255, 255, 0.3) 0%,
    rgba(255, 255, 255, 0) 60%
  );
  transform: rotate(30deg);
  animation: shine 3s infinite;
}

.platform-header h3 {
  margin: 0;
  font-size: 1.3rem;
  position: relative;
}

.platform-content {
  padding: 25px;
  text-align: center;
  flex-grow: 1;
  display: flex;
  flex-direction: column;
}

.platform-icon {
  font-size: 2.5rem;
  color: var(--primary-color);
  margin-bottom: 15px;
}

.platform-content p {
  margin-bottom: 20px;
  color: var(--text-color);
  flex-grow: 1;
}

/* 成员专区 */
.member-area {
  padding: 100px 0;
  background-color: var(--white);
  width: 100%;
}

.member-features {
  display: flex;
  flex-wrap: wrap;
  gap: 30px;
  justify-content: center;
}

.feature-card {
  flex: 1;
  min-width: 250px;
  max-width: 300px;
  background: var(--white);
  border-radius: 10px;
  padding: 30px;
  text-align: center;
  box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
  border: 1px solid rgba(30, 136, 229, 0.1);
  transition: all 0.3s;
}

.feature-card:hover {
  transform: translateY(-5px);
  box-shadow: 0 15px 40px rgba(0, 0, 0, 0.15);
}

.feature-icon {
  width: 60px;
  height: 60px;
  background: linear-gradient(135deg, var(--primary-color), var(--secondary-color));
  color: white;
  border-radius: 50%;
  display: flex;
  align-items: center;
  justify-content: center;
  margin: 0 auto 20px;
  font-size: 24px;
}

.feature-card h3 {
  margin-bottom: 15px;
  color: var(--primary-color);
}

.feature-card p {
  margin-bottom: 20px;
  color: var(--text-color);
}

/* 加入我们表单 */
.join-us {
  padding: 100px 0;
  text-align: center;
  background-color: var(--white);
  position: relative;
  width: 100%;
}

.join-us::before {
  content: "";
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: url('data:image/svg+xml;utf8,<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 100 100" preserveAspectRatio="none"><path d="M0,0 L100,0 L100,100 L0,100 Z" fill="none" stroke="%231e88e5" stroke-width="0.5" stroke-dasharray="5,5" /></svg>');
  opacity: 0.05;
  pointer-events: none;
}

#join-form {
  max-width: 600px;
  margin: 0 auto;
  text-align: left;
  background: rgba(255, 255, 255, 0.95);
  padding: 30px;
  border-radius: 10px;
  box-shadow: 0 5px 20px rgba(0, 0, 0, 0.1);
  backdrop-filter: blur(5px);
  border: 1px solid rgba(30, 136, 229, 0.1);
  position: relative;
  z-index: 1;
}

.form-group {
  margin-bottom: 20px;
}

.form-group label {
  display: block;
  margin-bottom: 8px;
  color: var(--dark-color);
  font-weight: 500;
}

#join-form input,
#join-form select,
#join-form textarea {
  width: 100%;
  padding: 12px 15px;
  border: 1px solid rgba(30, 136, 229, 0.3);
  border-radius: 6px;
  background-color: rgba(255, 255, 255, 0.9);
  transition: all 0.3s;
  box-shadow: inset 0 1px 3px rgba(0, 0, 0, 0.05);
  font-size: 1rem;
}

#join-form input:focus,
#join-form select:focus,
#join-form textarea:focus {
  border-color: var(--primary-color);
  box-shadow: 0 0 0 3px rgba(30, 136, 229, 0.2),
              inset 0 1px 3px rgba(0, 0, 0, 0.05);
  outline: none;
  background-color: var(--white);
}

#join-form select {
  appearance: none;
  background-image: url("data:image/svg+xml;charset=UTF-8,%3csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 24 24' fill='%231e88e5'%3e%3cpath d='M7 10l5 5 5-5z'/%3e%3c/svg%3e");
  background-repeat: no-repeat;
  background-position: right 15px center;
  background-size: 15px;
}

#join-form textarea {
  min-height: 120px;
  resize: vertical;
}

/* 页脚 */
footer {
  background: linear-gradient(135deg, var(--dark-color), var(--primary-color));
  color: var(--white);
  padding: 60px 0 30px;
  text-align: center;
  position: relative;
  width: 100%;
}

footer::before {
  content: "";
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: url('data:image/svg+xml;utf8,<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 100 100" preserveAspectRatio="none"><path d="M0,0 L100,0 L100,100 L0,100 Z" fill="none" stroke="%23ffffff" stroke-width="0.5" stroke-dasharray="5,5" /></svg>');
  opacity: 0.2;
  pointer-events: none;
}

.footer-content {
  position: relative;
  z-index: 1;
}

footer h3 {
  font-size: 1.8rem;
  margin-bottom: 15px;
}

footer p {
  max-width: 600px;
  margin: 0 auto 25px;
  opacity: 0.9;
}

.footer-links {
  display: flex;
  justify-content: center;
  list-style: none;
  margin: 25px 0;
  flex-wrap: wrap;
}

.footer-links li {
  margin: 0 15px;
}

.footer-links a {
  color: var(--white);
  text-decoration: none;
  opacity: 0.8;
  transition: opacity 0.3s;
  position: relative;
  padding-bottom: 5px;
}

.footer-links a::after {
  content: "";
  position: absolute;
  bottom: 0;
  left: 0;
  width: 0;
  height: 1px;
  background-color: var(--white);
  transition: width 0.3s;
}

.footer-links a:hover {
  opacity: 1;
}

.footer-links a:hover::after {
  width: 100%;
}

.copyright {
  margin-top: 30px;
  opacity: 0.7;
  font-size: 0.9rem;
}

/* ==================== 动画定义 ==================== */
@keyframes gradientFlow {
  0% { background-position: 0% 50%; }
  50% { background-position: 100% 50%; }
  100% { background-position: 0% 50%; }
}

@keyframes techPulse {
  0% { box-shadow: 0 0 0 0 rgba(30, 136, 229, 0.7); }
  70% { box-shadow: 0 0 0 10px rgba(30, 136, 229, 0); }
  100% { box-shadow: 0 0 0 0 rgba(30, 136, 229, 0); }
}

@keyframes shine {
  to {
    transform: translateX(100%) translateY(100%) rotate(30deg);
  }
}

@keyframes gridMove {
  0% { background-position: 0 0; }
  100% { background-position: 40px 40px; }
}

@keyframes float {
  0% {
    transform: translateY(0) translateX(0) rotate(0deg) scale(1);
    opacity: 0.3;
  }
  25% {
    transform: translateY(-50px) translateX(20px) rotate(90deg) scale(1.2);
    opacity: 0.5;
  }
  50% {
    transform: translateY(0) translateX(40px) rotate(180deg) scale(1);
    opacity: 0.7;
  }
  75% {
    transform: translateY(-30px) translateX(10px) rotate(270deg) scale(1.1);
    opacity: 0.5;
  }
  100% {
    transform: translateY(0) translateX(0) rotate(360deg) scale(1);
    opacity: 0.3;
  }
}

@keyframes lineFlow {
  0% { transform: translateX(-100%) rotate(0deg); }
  100% { transform: translateX(100vw) rotate(360deg); }
}

@keyframes codeFade {
  0% { opacity: 0; transform: translateY(0); }
  10% { opacity: 0.6; }
  90% { opacity: 0.6; }
  100% { opacity: 0; transform: translateY(-100px); }
}

/* 响应式设计 */
@media (max-width: 768px) {
  .hero h1 {
    font-size: 2.2rem;
  }
  
  .nav-links {
    display: none;
  }
  
  .mobile-menu-btn {
    display: block;
  }
  
  .mobile-menu {
    display: block;
  }
  
  .showcase-container {
    flex-direction: column;
  }
  
  .notice-board {
    flex-direction: column;
    align-items: center;
  }
  
  .notice {
    max-width: 100%;
  }
  
  .groups-container {
    flex-direction: column;
  }
  
  .group-card {
    flex: 1 1 100%;
  }
  
  .platform-container {
    grid-template-columns: 1fr;
  }
  
  .member-features {
    flex-direction: column;
    align-items: center;
  }
  
  .feature-card {
    min-width: 100%;
  }
  
  .section-title {
    font-size: 1.8rem;
  }
  
  #join-form {
    padding: 20px;
  }
}

@media (max-width: 480px) {
  .hero {
    padding: 100px 0 60px;
  }
  
  .hero h1 {
    font-size: 1.8rem;
  }
  
  .hero p {
    font-size: 1rem;
  }
  
  .section-title {
    font-size: 1.5rem;
  }
  
  .section-title::after {
    height: 2px;
    bottom: -5px;
  }
  
  .group-content h3, .platform-header h3, .feature-card h3 {
    font-size: 1.2rem;
  }
  
  footer h3 {
    font-size: 1.5rem;
  }
  
  .footer-links {
    flex-direction: column;
    gap: 10px;
  }
  
  .footer-links li {
    margin: 5px 0;
  }
}
</style>
