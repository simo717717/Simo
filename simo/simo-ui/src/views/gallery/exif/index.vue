<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="相机品牌" prop="cameraMake">
        <el-input
          v-model="queryParams.cameraMake"
          placeholder="请输入相机品牌"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="相机型号" prop="cameraModel">
        <el-input
          v-model="queryParams.cameraModel"
          placeholder="请输入相机型号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="镜头型号" prop="lensModel">
        <el-input
          v-model="queryParams.lensModel"
          placeholder="请输入镜头型号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="焦段 (如 50mm)" prop="focalLength">
        <el-input
          v-model="queryParams.focalLength"
          placeholder="请输入焦段 (如 50mm)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="光圈 (如 f/1.8)" prop="aperture">
        <el-input
          v-model="queryParams.aperture"
          placeholder="请输入光圈 (如 f/1.8)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="快门速度 (如 1/200s)" prop="exposureTime">
        <el-input
          v-model="queryParams.exposureTime"
          placeholder="请输入快门速度 (如 1/200s)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="ISO感光度" prop="iso">
        <el-input
          v-model="queryParams.iso"
          placeholder="请输入ISO感光度"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="拍摄纬度" prop="gpsLat">
        <el-input
          v-model="queryParams.gpsLat"
          placeholder="请输入拍摄纬度"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="拍摄经度" prop="gpsLng">
        <el-input
          v-model="queryParams.gpsLng"
          placeholder="请输入拍摄经度"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="实际拍摄时间" prop="takenTime">
        <el-date-picker clearable
          v-model="queryParams.takenTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择实际拍摄时间">
        </el-date-picker>
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
          v-hasPermi="['gallery:exif:add']"
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
          v-hasPermi="['gallery:exif:edit']"
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
          v-hasPermi="['gallery:exif:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['gallery:exif:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="exifList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="关联的图片ID (主键)" align="center" prop="photoId" />
      <el-table-column label="相机品牌" align="center" prop="cameraMake" />
      <el-table-column label="相机型号" align="center" prop="cameraModel" />
      <el-table-column label="镜头型号" align="center" prop="lensModel" />
      <el-table-column label="焦段 (如 50mm)" align="center" prop="focalLength" />
      <el-table-column label="光圈 (如 f/1.8)" align="center" prop="aperture" />
      <el-table-column label="快门速度 (如 1/200s)" align="center" prop="exposureTime" />
      <el-table-column label="ISO感光度" align="center" prop="iso" />
      <el-table-column label="拍摄纬度" align="center" prop="gpsLat" />
      <el-table-column label="拍摄经度" align="center" prop="gpsLng" />
      <el-table-column label="实际拍摄时间" align="center" prop="takenTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.takenTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['gallery:exif:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['gallery:exif:remove']"
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

    <!-- 添加或修改图片EXIF参数对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="相机品牌" prop="cameraMake">
          <el-input v-model="form.cameraMake" placeholder="请输入相机品牌" />
        </el-form-item>
        <el-form-item label="相机型号" prop="cameraModel">
          <el-input v-model="form.cameraModel" placeholder="请输入相机型号" />
        </el-form-item>
        <el-form-item label="镜头型号" prop="lensModel">
          <el-input v-model="form.lensModel" placeholder="请输入镜头型号" />
        </el-form-item>
        <el-form-item label="焦段 (如 50mm)" prop="focalLength">
          <el-input v-model="form.focalLength" placeholder="请输入焦段 (如 50mm)" />
        </el-form-item>
        <el-form-item label="光圈 (如 f/1.8)" prop="aperture">
          <el-input v-model="form.aperture" placeholder="请输入光圈 (如 f/1.8)" />
        </el-form-item>
        <el-form-item label="快门速度 (如 1/200s)" prop="exposureTime">
          <el-input v-model="form.exposureTime" placeholder="请输入快门速度 (如 1/200s)" />
        </el-form-item>
        <el-form-item label="ISO感光度" prop="iso">
          <el-input v-model="form.iso" placeholder="请输入ISO感光度" />
        </el-form-item>
        <el-form-item label="拍摄纬度" prop="gpsLat">
          <el-input v-model="form.gpsLat" placeholder="请输入拍摄纬度" />
        </el-form-item>
        <el-form-item label="拍摄经度" prop="gpsLng">
          <el-input v-model="form.gpsLng" placeholder="请输入拍摄经度" />
        </el-form-item>
        <el-form-item label="实际拍摄时间" prop="takenTime">
          <el-date-picker clearable
            v-model="form.takenTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择实际拍摄时间">
          </el-date-picker>
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
import { listExif, getExif, delExif, addExif, updateExif } from "@/api/gallery/exif"

export default {
  name: "Exif",
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
      // 图片EXIF参数表格数据
      exifList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        cameraMake: null,
        cameraModel: null,
        lensModel: null,
        focalLength: null,
        aperture: null,
        exposureTime: null,
        iso: null,
        gpsLat: null,
        gpsLng: null,
        takenTime: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    }
  },
  created() {
    this.getList()
  },
  methods: {
    /** 查询图片EXIF参数列表 */
    getList() {
      this.loading = true
      listExif(this.queryParams).then(response => {
        this.exifList = response.rows
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
        cameraMake: null,
        cameraModel: null,
        lensModel: null,
        focalLength: null,
        aperture: null,
        exposureTime: null,
        iso: null,
        gpsLat: null,
        gpsLng: null,
        takenTime: null
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
      this.title = "添加图片EXIF参数"
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const photoId = row.photoId || this.ids
      getExif(photoId).then(response => {
        this.form = response.data
        this.open = true
        this.title = "修改图片EXIF参数"
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.photoId != null) {
            updateExif(this.form).then(response => {
              this.$modal.msgSuccess("修改成功")
              this.open = false
              this.getList()
            })
          } else {
            addExif(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除图片EXIF参数编号为"' + photoIds + '"的数据项？').then(function() {
        return delExif(photoIds)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess("删除成功")
      }).catch(() => {})
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('gallery/exif/export', {
        ...this.queryParams
      }, `exif_${new Date().getTime()}.xlsx`)
    }
  }
}
</script>
