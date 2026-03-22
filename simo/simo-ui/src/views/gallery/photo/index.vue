<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="上传者ID (关联系统表 sys_user)" prop="userId">
        <el-input
          v-model="queryParams.userId"
          placeholder="请输入上传者ID (关联系统表 sys_user)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="图片标题" prop="title">
        <el-input
          v-model="queryParams.title"
          placeholder="请输入图片标题"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="文件大小(字节)" prop="fileSize">
        <el-input
          v-model="queryParams.fileSize"
          placeholder="请输入文件大小(字节)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="权限级别 (0:公开, 1:私有, 2:指定好友可见, 3:仅链接可见)" prop="permissionLevel">
        <el-select v-model="queryParams.permissionLevel" placeholder="请选择权限级别 (0:公开, 1:私有, 2:指定好友可见, 3:仅链接可见)" clearable>
          <el-option
            v-for="dict in dict.type.biz_photo_permission"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="AI处理状态 (0:未分析, 1:分析完成, 2:解析失败)" prop="aiStatus">
        <el-select v-model="queryParams.aiStatus" placeholder="请选择AI处理状态 (0:未分析, 1:分析完成, 2:解析失败)" clearable>
          <el-option
            v-for="dict in dict.type.biz_ai_status"
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
          v-hasPermi="['gallery:photo:add']"
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
          v-hasPermi="['gallery:photo:edit']"
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
          v-hasPermi="['gallery:photo:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['gallery:photo:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="photoList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="图片主键ID" align="center" prop="photoId" />
      <el-table-column label="上传者ID (关联系统表 sys_user)" align="center" prop="userId" />
      <el-table-column label="图片标题" align="center" prop="title" />
      <el-table-column label="图片描述" align="center" prop="description" />
      <el-table-column label="文件OSS或本地存储路径" align="center" prop="filePath" width="100">
        <template slot-scope="scope">
          <image-preview :src="scope.row.filePath" :width="50" :height="50"/>
        </template>
      </el-table-column>
      <el-table-column label="文件后缀格式 (JPG, PNG, RAW)" align="center" prop="fileType" />
      <el-table-column label="文件大小(字节)" align="center" prop="fileSize" />
      <el-table-column label="权限级别 (0:公开, 1:私有, 2:指定好友可见, 3:仅链接可见)" align="center" prop="permissionLevel">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.biz_photo_permission" :value="scope.row.permissionLevel"/>
        </template>
      </el-table-column>
      <el-table-column label="AI处理状态 (0:未分析, 1:分析完成, 2:解析失败)" align="center" prop="aiStatus">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.biz_ai_status" :value="scope.row.aiStatus"/>
        </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['gallery:photo:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['gallery:photo:remove']"
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

    <!-- 添加或修改图片核心信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="上传者ID (关联系统表 sys_user)" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入上传者ID (关联系统表 sys_user)" />
        </el-form-item>
        <el-form-item label="图片标题" prop="title">
          <el-input v-model="form.title" placeholder="请输入图片标题" />
        </el-form-item>
        <el-form-item label="图片描述" prop="description">
          <el-input v-model="form.description" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="文件OSS或本地存储路径" prop="filePath">
          <image-upload v-model="form.filePath"/>
        </el-form-item>
        <el-form-item label="文件大小(字节)" prop="fileSize">
          <el-input v-model="form.fileSize" placeholder="请输入文件大小(字节)" />
        </el-form-item>
        <el-form-item label="权限级别 (0:公开, 1:私有, 2:指定好友可见, 3:仅链接可见)" prop="permissionLevel">
          <el-select v-model="form.permissionLevel" placeholder="请选择权限级别 (0:公开, 1:私有, 2:指定好友可见, 3:仅链接可见)">
            <el-option
              v-for="dict in dict.type.biz_photo_permission"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="AI处理状态 (0:未分析, 1:分析完成, 2:解析失败)" prop="aiStatus">
          <el-select v-model="form.aiStatus" placeholder="请选择AI处理状态 (0:未分析, 1:分析完成, 2:解析失败)">
            <el-option
              v-for="dict in dict.type.biz_ai_status"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="删除标志 (0代表存在 2代表删除)" prop="delFlag">
          <el-input v-model="form.delFlag" placeholder="请输入删除标志 (0代表存在 2代表删除)" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
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
import { listPhoto, getPhoto, delPhoto, addPhoto, updatePhoto } from "@/api/gallery/photo"

export default {
  name: "Photo",
  dicts: ['biz_photo_permission', 'biz_ai_status'],
  data() {
    return {
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
      // 图片核心信息表格数据
      photoList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userId: null,
        title: null,
        description: null,
        filePath: null,
        fileType: null,
        fileSize: null,
        permissionLevel: null,
        aiStatus: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        userId: [
          { required: true, message: "上传者ID (关联系统表 sys_user)不能为空", trigger: "blur" }
        ],
        filePath: [
          { required: true, message: "文件OSS或本地存储路径不能为空", trigger: "blur" }
        ],
        fileType: [
          { required: true, message: "文件后缀格式 (JPG, PNG, RAW)不能为空", trigger: "change" }
        ],
        fileSize: [
          { required: true, message: "文件大小(字节)不能为空", trigger: "blur" }
        ],
      }
    }
  },
  created() {
    this.getList()
  },
  methods: {
    /** 查询图片核心信息列表 */
    getList() {
      this.loading = true
      listPhoto(this.queryParams).then(response => {
        this.photoList = response.rows
        this.total = response.total
        this.loading = false
      })
    },
    // 取消按钮
    cancel() {
      this.open = false
      this.reset()
    },
    // 表单重置
    reset() {
      this.form = {
        photoId: null,
        userId: null,
        title: null,
        description: null,
        filePath: null,
        fileType: null,
        fileSize: null,
        permissionLevel: null,
        aiStatus: null,
        delFlag: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remark: null
      }
      this.resetForm("form")
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1
      this.getList()
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm")
      this.handleQuery()
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.photoId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset()
      this.open = true
      this.title = "添加图片核心信息"
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const photoId = row.photoId || this.ids
      getPhoto(photoId).then(response => {
        this.form = response.data
        this.open = true
        this.title = "修改图片核心信息"
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.photoId != null) {
            updatePhoto(this.form).then(response => {
              this.$modal.msgSuccess("修改成功")
              this.open = false
              this.getList()
            })
          } else {
            addPhoto(this.form).then(response => {
              this.$modal.msgSuccess("新增成功")
              this.open = false
              this.getList()
            })
          }
        }
      })
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const photoIds = row.photoId || this.ids
      this.$modal.confirm('是否确认删除图片核心信息编号为"' + photoIds + '"的数据项？').then(function() {
        return delPhoto(photoIds)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess("删除成功")
      }).catch(() => {})
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('gallery/photo/export', {
        ...this.queryParams
      }, `photo_${new Date().getTime()}.xlsx`)
    }
  }
}
</script>
