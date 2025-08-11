<template>
  <div class="duty-schedule-container">
    <!-- 背景特效 -->
    <div class="background-effects">
      <div class="grid-bg"></div>
      <div class="floating-particles"></div>
      <div class="dynamic-lines"></div>
      <div class="code-elements"></div>
    </div>
    
    <div class="duty-content">
      <h1 class="page-title">
        <i class="fas fa-calendar-alt"></i> 值日表查看
      </h1>
      
      <div class="week-toggle">
        <button 
          class="toggle-btn" 
          :class="{ 'active': currentWeekType === 'single' }"
          @click="currentWeekType = 'single'"
        >
          单周值日表
        </button>
        <button 
          class="toggle-btn" 
          :class="{ 'active': currentWeekType === 'double' }"
          @click="currentWeekType = 'double'"
        >
          双周值日表
        </button>
      </div>
      
      <!-- 单周值日表 -->
      <div class="week-schedule" v-if="currentWeekType === 'single'">
        <h2 class="week-title">单周值日安排</h2>
        
        <div class="horizontal-table-container">
          <table class="duty-table">
            <thead>
              <tr>
                <th class="week-header">单周</th>
                <th>周一(拖地)</th>
                <th>周二</th>
                <th>周三(拖地)</th>
                <th>周四</th>
                <th>周五(拖地)</th>
                <th>周六</th>
                <th>周日(拖地)</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td class="duty-type">值日</td>
                <td>李想 祁奕凯</td>
                <td>赵玺超</td>
                <td>刘荣旋 曹济麟</td>
                <td>刘亚宁</td>
                <td>柳泽 宋仕发</td>
                <td>宋镇杨</td>
                <td>侯可欣 张雨萌 王萌 阴雅雯</td>
              </tr>
              <tr>
                <td class="duty-type">打水</td>
                <td>李想 祁奕凯</td>
                <td>赵玺超</td>
                <td>刘荣旋 曹济麟</td>
                <td>刘亚宁</td>
                <td>柳泽 宋仕发</td>
                <td>宋镇杨</td>
                <td>侯可欣 张雨萌 王萌 栗玉彤</td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
      
      <!-- 双周值日表 -->
      <div class="week-schedule" v-if="currentWeekType === 'double'">
        <h2 class="week-title">双周值日安排</h2>
        
        <div class="horizontal-table-container">
          <table class="duty-table">
            <thead>
              <tr>
                <th class="week-header">双周</th>
                <th>周一</th>
                <th>周二(拖地)</th>
                <th>周三</th>
                <th>周四(拖地)</th>
                <th>周五</th>
                <th>周六(拖地)</th>
                <th>周日</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td class="duty-type">值日</td>
                <td>王中巍</td>
                <td>刘佳璐 田洋</td>
                <td>栗玉彤</td>
                <td>国嘉茗 何栩萌</td>
                <td>杜国鑫</td>
                <td>刘鑫茗 王奕文</td>
                <td>侯可欣 张雨萌 王萌</td>
              </tr>
              <tr>
                <td class="duty-type">打水</td>
                <td>王中巍</td>
                <td>刘佳璐 田洋</td>
                <td>阴雅雯</td>
                <td>国嘉茗 何栩萌</td>
                <td>杜国鑫</td>
                <td>刘鑫茗 王奕文</td>
                <td>侯可欣 张雨萌 王萌</td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'DutyScheduleView',
  data() {
    return {
      currentWeekType: 'single' // 'single' 或 'double'
    }
  }
}
</script>

<style scoped>
/* 基础变量 */
:root {
  --primary-color: #1e88e5;
  --secondary-color: #42a5f5;
  --accent-color: #0d47a1;
  --light-bg: #f5f9ff;
  --card-bg: rgba(255, 255, 255, 0.95);
  --text-color: #333;
  --text-dark: #222;
  --border-color: rgba(0, 0, 0, 0.1);
}

/* 基础样式 */
.duty-schedule-container {
  position: relative;
  min-height: 100vh;
  padding: 20px 10px;
  width: 1200px;
  min-width: 1000px;
  background-color: var(--light-bg);
  /* overflow-x: auto; */
  margin-top: 80px;
  font-family: 'Segoe UI', 'PingFang SC', 'Microsoft YaHei', sans-serif;
}

/* 背景特效 */
.background-effects {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: -1;
  overflow: hidden;
}

.grid-bg {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: 
    linear-gradient(rgba(30, 136, 229, 0.05) 1px, transparent 1px),
    linear-gradient(90deg, rgba(30, 136, 229, 0.05) 1px, transparent 1px);
  background-size: 30px 30px;
  animation: gridMove 20s linear infinite;
}

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
  opacity: 0.15;
  animation: float 15s infinite ease-in-out;
  filter: blur(1px);
}

.dynamic-lines {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  pointer-events: none;
  overflow: hidden;
}

.line {
  position: absolute;
  height: 1px;
  background: linear-gradient(90deg, rgba(30, 136, 229, 0.3), transparent);
  animation: lineFlow 25s linear infinite;
}

.code-elements {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  pointer-events: none;
}

.code-element {
  position: absolute;
  font-family: 'Courier New', monospace;
  color: rgba(30, 136, 229, 0.6);
  opacity: 0;
  animation: codeFade 8s infinite;
}

/* 页面内容容器：最大宽度 + 居中 */
.duty-content {
  max-width: 1500px;  /* 核心：限制最大宽度，避免放大后过宽 */
  width: 100%;        /* 小于最大宽度时撑满屏幕 */
  min-width: 800px;   /* 保证内容不挤压 */
  margin: 0 auto;     /* 核心：水平居中 */
  padding: 25px;
  background-color: var(--card-bg);
  border-radius: 12px;
  box-shadow: 0 4px 20px rgba(0, 0, 0, 0.08);
  backdrop-filter: blur(5px);
  border: 1px solid rgba(255, 255, 255, 0.2);
  box-sizing: border-box;
}

.page-title {
  font-size: 2rem;
  color: var(--accent-color);
  margin-bottom: 25px;
  text-align: center;
  position: relative;
}

.page-title::after {
  content: "";
  position: absolute;
  bottom: -10px;
  left: 50%;
  transform: translateX(-50%);
  width: 80px;
  height: 3px;
  background: linear-gradient(90deg, var(--primary-color), var(--secondary-color));
  border-radius: 3px;
}

/* 周切换按钮 */
.week-toggle {
  display: flex;
  justify-content: center;
  margin-bottom: 25px;
  gap: 15px;
}

.toggle-btn {
  padding: 10px 25px;
  border-radius: 30px;
  border: 2px solid var(--primary-color);
  background: transparent;
  color: var(--primary-color);
  font-weight: 500;
  cursor: pointer;
  transition: all 0.3s;
}

.toggle-btn.active {
  background: var(--primary-color);
  color: white;
}

.toggle-btn:hover {
  transform: translateY(-2px);
  box-shadow: 0 3px 10px rgba(0, 0, 0, 0.1);
}

/* 周值日表 */
.week-schedule {
  margin-top: 15px;
}

.week-title {
  color: rgba(30, 136, 229, 0.9);
  text-align: center;
  margin-bottom: 15px;
  font-size: 1.5rem;
}

/* 横向表格容器：自适应宽度 */
.horizontal-table-container {
  width: 100%;
  overflow-x: auto;
  margin-bottom: 20px;
  border-radius: 8px;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
  box-sizing: border-box;
}

.duty-table {
  width: 100%;          /* 跟随容器宽度 */
  min-width: 700px;     /* 避免内容过度挤压 */
  border-collapse: collapse;
  background: white;
  border-radius: 8px;
  overflow: hidden;
  margin: 0 auto;
}

.duty-table th, .duty-table td {
  padding: 14px 16px;
  text-align: center;
  border: 1px solid var(--border-color);
}

.duty-table th {
  background-color: var(--primary-color);
  color: rgba(30, 136, 229, 0.9);
  font-weight: 600;
  font-size: 1.05rem;
}

.duty-table .week-header {
  background-color: var(--accent-color);
  color: rgba(30, 136, 229, 0.9);
  font-weight: 600;
}

.duty-table .duty-type {
  font-weight: bold;
  background-color: rgba(30, 136, 229, 0.1);
  color: var(--text-dark);
}

.duty-table tr:nth-child(even) {
  background-color: rgba(30, 136, 229, 0.05);
}

.duty-table tr:hover {
  background-color: rgba(30, 136, 229, 0.1);
}

.duty-table td {
  color: var(--text-dark);
}

/* 动画 */
@keyframes gridMove {
  0% { background-position: 0 0; }
  100% { background-position: 30px 30px; }
}

@keyframes float {
  0%, 100% { transform: translate(0, 0); }
  50% { transform: translate(20px, -20px); }
}

@keyframes lineFlow {
  0% { transform: translateX(-100%) rotate(0deg); }
  100% { transform: translateX(100vw) rotate(360deg); }
}

@keyframes codeFade {
  0%, 100% { opacity: 0; transform: translateY(0); }
  50% { opacity: 0.6; transform: translateY(-10px); }
}
</style>