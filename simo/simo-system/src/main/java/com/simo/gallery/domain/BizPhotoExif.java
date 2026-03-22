package com.simo.gallery.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.simo.common.annotation.Excel;
import com.simo.common.core.domain.BaseEntity;

/**
 * 图片EXIF参数对象 biz_photo_exif
 * 
 * @author ruoyi
 * @date 2026-03-22
 */
public class BizPhotoExif extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 关联的图片ID (主键) */
    private Long photoId;

    /** 相机品牌 */
    @Excel(name = "相机品牌")
    private String cameraMake;

    /** 相机型号 */
    @Excel(name = "相机型号")
    private String cameraModel;

    /** 镜头型号 */
    @Excel(name = "镜头型号")
    private String lensModel;

    /** 焦段 (如 50mm) */
    @Excel(name = "焦段 (如 50mm)")
    private String focalLength;

    /** 光圈 (如 f/1.8) */
    @Excel(name = "光圈 (如 f/1.8)")
    private String aperture;

    /** 快门速度 (如 1/200s) */
    @Excel(name = "快门速度 (如 1/200s)")
    private String exposureTime;

    /** ISO感光度 */
    @Excel(name = "ISO感光度")
    private String iso;

    /** 拍摄纬度 */
    @Excel(name = "拍摄纬度")
    private BigDecimal gpsLat;

    /** 拍摄经度 */
    @Excel(name = "拍摄经度")
    private BigDecimal gpsLng;

    /** 实际拍摄时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "实际拍摄时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date takenTime;

    public void setPhotoId(Long photoId) 
    {
        this.photoId = photoId;
    }

    public Long getPhotoId() 
    {
        return photoId;
    }

    public void setCameraMake(String cameraMake) 
    {
        this.cameraMake = cameraMake;
    }

    public String getCameraMake() 
    {
        return cameraMake;
    }

    public void setCameraModel(String cameraModel) 
    {
        this.cameraModel = cameraModel;
    }

    public String getCameraModel() 
    {
        return cameraModel;
    }

    public void setLensModel(String lensModel) 
    {
        this.lensModel = lensModel;
    }

    public String getLensModel() 
    {
        return lensModel;
    }

    public void setFocalLength(String focalLength) 
    {
        this.focalLength = focalLength;
    }

    public String getFocalLength() 
    {
        return focalLength;
    }

    public void setAperture(String aperture) 
    {
        this.aperture = aperture;
    }

    public String getAperture() 
    {
        return aperture;
    }

    public void setExposureTime(String exposureTime) 
    {
        this.exposureTime = exposureTime;
    }

    public String getExposureTime() 
    {
        return exposureTime;
    }

    public void setIso(String iso) 
    {
        this.iso = iso;
    }

    public String getIso() 
    {
        return iso;
    }

    public void setGpsLat(BigDecimal gpsLat) 
    {
        this.gpsLat = gpsLat;
    }

    public BigDecimal getGpsLat() 
    {
        return gpsLat;
    }

    public void setGpsLng(BigDecimal gpsLng) 
    {
        this.gpsLng = gpsLng;
    }

    public BigDecimal getGpsLng() 
    {
        return gpsLng;
    }

    public void setTakenTime(Date takenTime) 
    {
        this.takenTime = takenTime;
    }

    public Date getTakenTime() 
    {
        return takenTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("photoId", getPhotoId())
            .append("cameraMake", getCameraMake())
            .append("cameraModel", getCameraModel())
            .append("lensModel", getLensModel())
            .append("focalLength", getFocalLength())
            .append("aperture", getAperture())
            .append("exposureTime", getExposureTime())
            .append("iso", getIso())
            .append("gpsLat", getGpsLat())
            .append("gpsLng", getGpsLng())
            .append("takenTime", getTakenTime())
            .toString();
    }
}
