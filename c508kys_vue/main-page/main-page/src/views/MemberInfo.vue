<template>
  <div class="member-info-container">
    <!-- 背景特效 -->
    <div class="background-effects">
      <div class="grid-bg"></div>
      <div class="floating-particles" id="floating-particles"></div>
      <div class="dynamic-lines" id="dynamic-lines"></div>
      <div id="code-elements"></div>
    </div>
    
    <h1 class="page-title">个人信息管理</h1>
    
    <div class="info-layout">
      <!-- 侧边栏：个人信息概览和权限设置 -->
      <div class="profile-sidebar">
        <!-- 头像上传区域 -->
        <div class="profile-avatar">
          <img src="/src/assets/logo.svg" alt="个人头像" class="avatar-img">
          <div class="avatar-upload">
            <button class="upload-btn">更换头像</button>
            <input type="file" class="upload-input" accept="image/*">
          </div>
        </div>
        
        <!-- 个人信息概览 -->
        <div class="profile-overview">
          <h3>基本信息</h3>
          <div class="profile-info-item">
            <strong>姓名：</strong>
            <span></span>
          </div>
          <div class="profile-info-item">
            <strong>学号：</strong>
            <span></span>
          </div>
          <div class="profile-info-item">
            <strong>专业：</strong>
            <span></span>
          </div>
          <div class="profile-info-item">
            <strong>组别：</strong>
            <span></span>
          </div>
          <div class="profile-info-item">
            <strong>权限等级：</strong>
            <span class="permission-badge member">普通成员</span>
          </div>
        </div>
        
        <!-- 权限设置区域 -->
        <div class="permission-settings">
          <h3>信息查看权限</h3>
          <div class="permission-group">
            <label for="info-perm">信息可见范围</label>
            <select id="info-perm" class="permission-select">
              <option value="public">公开 - 所有人可见</option>
              <option value="members" selected>仅成员可见</option>
              <option value="leaders">仅组长及以上可见</option>
              <option value="admin">仅管理员可见</option>
            </select>
          </div>
          
          <button class="save-btn">保存权限设置</button>
        </div>
      </div>
      
      <!-- 主内容区域 -->
      <div class="main-content">
        <!-- 个人信息编辑卡片 -->
        <div class="info-card">
          <h2 class="card-title">
            详细信息
            <button class="edit-btn">
              <i class="fas fa-edit"></i> 编辑信息
            </button>
          </h2>
          
          <div class="form-grid">
            <div class="form-group">
              <label for="fullname">姓名</label>
              <input type="text" id="fullname" class="form-control" value="张三" disabled>
            </div>
            <div class="form-group">
              <label for="student-id">学号</label>
              <input type="text" id="student-id" class="form-control" value="2022001001" disabled>
            </div>
            <div class="form-group">
              <label for="gender">性别</label>
              <select id="gender" class="form-control" disabled>
                <option value="male" selected>男</option>
                <option value="female">女</option>
              </select>
            </div>
            <div class="form-group">
              <label for="birthdate">出生日期</label>
              <input type="date" id="birthdate" class="form-control" value="2004-03-15" disabled>
            </div>
            <div class="form-group">
              <label for="major">专业</label>
              <input type="text" id="major" class="form-control" value="计算机科学与技术" disabled>
            </div>
            <div class="form-group">
              <label for="grade">年级</label>
              <input type="text" id="grade" class="form-control" value="2022级" disabled>
            </div>
            <div class="form-group">
              <label for="email">邮箱</label>
              <input type="email" id="email" class="form-control" value="zhangsan@example.com" disabled>
            </div>
            <div class="form-group">
              <label for="phone">联系电话</label>
              <input type="tel" id="phone" class="form-control" value="13800138000" disabled>
            </div>
            <div class="form-group">
              <label for="research-group">所属研究组</label>
              <select id="research-group" class="form-control" disabled>
                <option value="">请选择...</option>
                <option value="mobile" selected>移动开发技术组</option>
                <option value="frontend">移动前端交互组</option>
                <option value="ml">机器学习组</option>
              </select>
            </div>
            <div class="form-group">
              <label for="entry-date">加入时间</label>
              <input type="date" id="entry-date" class="form-control" value="2022-09-10" disabled>
            </div>
            <div class="form-group">
              <label for="skills">专业技能</label>
              <input type="text" id="skills" class="form-control" value="Java, Kotlin, Android开发" disabled>
            </div>
            <div class="form-group">
              <label for="interest">研究兴趣</label>
              <input type="text" id="interest" class="form-control" value="移动应用开发、人工智能应用" disabled>
            </div>
          </div>
          
          <div class="form-actions">
            <button class="save-btn" style="display: none;">保存修改</button>
          </div>
        </div>
        
        <!-- 课程表卡片 -->
        <div class="info-card">
          <h2 class="card-title">
            课程表
            <button class="fetch-btn" @click="fetchTimetable">
              <i class="fas fa-external-link-alt"></i> 获取最新课表
            </button>
          </h2>
          
          <div class="timetable-container">
            <table class="timetable">
      <thead>
        <tr>
          <th class="time-column">时间</th>
          <!-- 循环渲染星期标题 -->
          <th v-for="(day, index) in weekdays" :key="index">
            {{ day }}
          </th>
        </tr>
      </thead>
      <tbody>
        <!-- 循环渲染每个时间段的行 -->
        <tr v-for="(timeSlot, slotIndex) in timetableData" :key="slotIndex">
          <td class="time-column">{{ timeSlot.time }}</td>
          
          <!-- 循环渲染每天的课程单元格 -->
          <td v-for="(course, dayIndex) in timeSlot.courses" :key="dayIndex">
            <div class="course-cell" v-if="course">
              <div class="course-name">{{ course.name }}</div>
              <div class="course-info">{{ course.info }}</div>
            </div>
          </td>
        </tr>
      </tbody>
    </table>
          </div>
        </div>
        
        <!-- 成绩信息卡片 -->
        <div class="info-card">
          <h2 class="card-title">
            成绩信息
            <button class="fetch-btn" @click="fetchGrades">
              <i class="fas fa-external-link-alt"></i> 获取最新成绩
            </button>
          </h2>
          
          <div class="grades-container">
  <table class="grades-table">
    <thead>
      <tr>
        <th>课程名称</th>
        <th>学分</th>
        <th>成绩</th>
        <th>绩点</th>
        <th>学期</th>
      </tr>
    </thead>
    <tbody>
      <!-- 循环渲染成绩数据 -->
      <tr v-for="(grade, index) in gradesData" :key="index">
        <td>{{ grade.courseName }}</td>
        <td>{{ grade.credit }}</td>
        <td>
          <span :class="['grade', grade.gradeLevel]">
            {{ grade.score }}
          </span>
        </td>
        <td>{{ grade.gpa }}</td>
        <td>{{ grade.semester }}</td>
      </tr>
    </tbody>
  </table>
</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {

data(){
return {
  //成绩的数据，具体再改
     gradesData: [
      
    ],
  //课表的数据
    courseData:[

    ]
  }
},
  name: 'MemberInfo',
  methods: {
    fetchTimetable() {
      // 跳转到正方系统
      window.open('https://baidu.com', '_blank');
    },
    fetchGrades() {
      // 跳转到正方系统
      window.open('https://example.com', '_blank');
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
  --text-light: #666;
  --border-color: rgba(0, 0, 0, 0.1);
  --success-color: #52c41a;
  --warning-color: #faad14;
  --error-color: #f5222d;
}

/* 基础样式 */
.member-info-container {
  position: relative;
  min-height: 100vh;
  padding: 20px;
  color: var(--text-color);
  background-color: var(--light-bg);
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

@keyframes gridMove {
  0% { background-position: 0 0; }
  100% { background-position: 30px 30px; }
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

@keyframes float {
  0%, 100% { transform: translate(0, 0); }
  50% { transform: translate(20px, -20px); }
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

@keyframes lineFlow {
  0% { transform: translateX(-100%) rotate(0deg); }
  100% { transform: translateX(100vw) rotate(360deg); }
}

/* 页面标题 */
.page-title {
  font-size: 2rem;
  color: var(--accent-color);
  margin-bottom: 30px;
  text-align: center;
  position: relative;
  display: inline-block;
  width: 100%;
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

/* 布局 */
.info-layout {
  display: flex;
  gap: 20px;
  max-width: 1400px;
  margin: 0 auto;
}

.profile-sidebar {
  flex: 0 0 300px;
  display: flex;
  flex-direction: column;
  gap: 20px;
}

.main-content {
  flex: 1;
  display: flex;
  flex-direction: column;
  gap: 20px;
}

/* 卡片样式 */
.info-card {
  background-color: var(--card-bg);
  border-radius: 12px;
  box-shadow: 0 4px 20px rgba(0, 0, 0, 0.08);
  padding: 25px;
  transition: all 0.3s ease;
  backdrop-filter: blur(5px);
  border: 1px solid rgba(255, 255, 255, 0.2);
}

.info-card:hover {
  transform: translateY(-5px);
  box-shadow: 0 8px 30px rgba(0, 0, 0, 0.12);
}

.card-title {
  font-size: 1.4rem;
  color: var(--accent-color);
  margin: 0 0 20px 0;
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding-bottom: 15px;
  border-bottom: 1px solid var(--border-color);
}

/* 头像区域 */
.profile-avatar {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 20px;
  background-color: var(--card-bg);
  border-radius: 12px;
  box-shadow: 0 4px 15px rgba(0, 0, 0, 0.05);
}

.avatar-img {
  width: 120px;
  height: 120px;
  border-radius: 50%;
  object-fit: cover;
  border: 3px solid var(--primary-color);
  margin-bottom: 15px;
}

.avatar-upload {
  position: relative;
  width: 100%;
  text-align: center;
}

.upload-btn {
  background-color: var(--primary-color);
  color: white;
  border: none;
  padding: 8px 15px;
  border-radius: 6px;
  cursor: pointer;
  transition: all 0.3s;
  font-size: 0.9rem;
}

.upload-btn:hover {
  background-color: var(--accent-color);
  transform: translateY(-2px);
}

.upload-input {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  opacity: 0;
  cursor: pointer;
}

/* 个人信息概览 */
.profile-overview {
  background-color: var(--card-bg);
  padding: 20px;
  border-radius: 12px;
  box-shadow: 0 4px 15px rgba(0, 0, 0, 0.05);
}

.profile-overview h3 {
  margin-top: 0;
  margin-bottom: 15px;
  color: var(--accent-color);
  font-size: 1.2rem;
  padding-bottom: 10px;
  border-bottom: 1px solid var(--border-color);
}

.profile-info-item {
  margin-bottom: 12px;
  display: flex;
}

.profile-info-item strong {
  flex: 0 0 80px;
  color: var(--text-light);
}

/* 权限徽章 */
.permission-badge {
  display: inline-block;
  padding: 3px 8px;
  border-radius: 4px;
  font-size: 0.8rem;
  font-weight: 500;
}

.permission-badge.member {
  background-color: #e6f7ff;
  color: #1890ff;
  border: 1px solid #91d5ff;
}

.permission-badge.leader {
  background-color: #f6ffed;
  color: #52c41a;
  border: 1px solid #b7eb8f;
}

.permission-badge.admin {
  background-color: #fff2e8;
  color: #fa8c16;
  border: 1px solid #ffd591;
}

/* 权限设置 */
.permission-settings {
  background-color: var(--card-bg);
  padding: 20px;
  border-radius: 12px;
  box-shadow: 0 4px 15px rgba(0, 0, 0, 0.05);
}

.permission-settings h3 {
  margin-top: 0;
  margin-bottom: 15px;
  color: var(--accent-color);
  font-size: 1.2rem;
  padding-bottom: 10px;
  border-bottom: 1px solid var(--border-color);
}

.permission-group {
  margin-bottom: 15px;
}

.permission-group label {
  display: block;
  margin-bottom: 8px;
  color: var(--text-light);
  font-size: 0.9rem;
}

.permission-select {
  width: 100%;
  padding: 10px;
  border-radius: 6px;
  border: 1px solid var(--border-color);
  background-color: white;
  font-size: 0.9rem;
}

.save-btn {
  width: 100%;
  padding: 10px;
  background-color: var(--primary-color);
  color: white;
  border: none;
  border-radius: 6px;
  cursor: pointer;
  transition: all 0.3s;
  font-size: 0.95rem;
}

.save-btn:hover {
  background-color: var(--accent-color);
  transform: translateY(-2px);
}

/* 表单样式 */
.form-grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(250px, 1fr));
  gap: 20px;
}

.form-group {
  margin-bottom: 15px;
}

.form-group label {
  display: block;
  margin-bottom: 8px;
  color: var(--text-light);
  font-size: 0.9rem;
}

.form-control {
  width: 100%;
  padding: 10px;
  border-radius: 6px;
  border: 1px solid var(--border-color);
  font-size: 0.95rem;
  transition: all 0.3s;
}

.form-control:disabled {
  background-color: #f5f5f5;
  color: var(--text-light);
}

.form-control:focus {
  outline: none;
  border-color: var(--primary-color);
  box-shadow: 0 0 0 2px rgba(30, 136, 229, 0.2);
}

/* 按钮样式 */
.edit-btn, .fetch-btn {
  background-color: transparent;
  color: var(--primary-color);
  border: 1px solid var(--primary-color);
  padding: 6px 12px;
  border-radius: 6px;
  cursor: pointer;
  transition: all 0.3s;
  font-size: 0.9rem;
  display: flex;
  align-items: center;
  gap: 5px;
}

.edit-btn:hover, .fetch-btn:hover {
  background-color: rgba(30, 136, 229, 0.1);
  transform: translateY(-2px);
}

/* 课程表样式 */
.timetable-container {
  overflow-x: auto;
  margin-top: 15px;
}

.timetable {
  width: 100%;
  border-collapse: collapse;
  min-width: 800px;
}

.timetable th, .timetable td {
  padding: 12px;
  text-align: center;
  border: 1px solid var(--border-color);
}

.timetable th {
  background-color: #f0f7ff;
  color: var(--accent-color);
  font-weight: 500;
}

.time-column {
  width: 120px;
  background-color: #f0f7ff;
  color: var(--accent-color);
  font-weight: 500;
}

.course-cell {
  padding: 8px;
  border-radius: 4px;
  background-color: #f5f9ff;
}

.course-name {
  font-weight: 500;
  color: var(--accent-color);
  margin-bottom: 5px;
}

.course-info {
  font-size: 0.8rem;
  color: var(--text-light);
}

/* 成绩表格样式 */
.grades-container {
  overflow-x: auto;
  margin-top: 15px;
}

.grades-table {
  width: 100%;
  border-collapse: collapse;
  min-width: 600px;
}

.grades-table th, .grades-table td {
  padding: 12px;
  text-align: left;
  border-bottom: 1px solid var(--border-color);
}

.grades-table th {
  background-color: #f0f7ff;
  color: var(--accent-color);
  font-weight: 500;
  position: sticky;
  top: 0;
}

.grades-table tr:hover {
  background-color: #f5f9ff;
}

/* 成绩等级样式 */
.grade {
  display: inline-block;
  padding: 3px 8px;
  border-radius: 4px;
  font-weight: 500;
  color: white;
  min-width: 40px;
  text-align: center;
}

.grade.A {
  background-color: var(--success-color);
}

.grade.B {
  background-color: var(--primary-color);
}

.grade.C {
  background-color: var(--warning-color);
}

.grade.D {
  background-color: #fa8c16;
}

.grade.F {
  background-color: var(--error-color);
}

/* 响应式设计 */
@media (max-width: 1200px) {
  .info-layout {
    flex-direction: column;
  }
  
  .profile-sidebar {
    flex: 1;
    width: 100%;
  }
}

@media (max-width: 768px) {
  .page-title {
    font-size: 1.6rem;
  }
  
  .card-title {
    font-size: 1.2rem;
    flex-direction: column;
    align-items: flex-start;
    gap: 10px;
  }
  
  .form-grid {
    grid-template-columns: 1fr;
  }
  
  .timetable th, 
  .timetable td,
  .grades-table th,
  .grades-table td {
    padding: 8px;
    font-size: 0.9rem;
  }
  
  .avatar-img {
    width: 100px;
    height: 100px;
  }
}
</style>