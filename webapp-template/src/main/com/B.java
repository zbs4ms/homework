/**
 * Created by zbs on 2017/3/1.
 */
public class B {
    //状态 0 不可用 1 可用
    Integer status;
    //类型 0 文字 1 图片
    Integer type;
    //文字类型有,其他没有
    String editContent;
    //图片有,其他没有
    Integer imageWidth;
    Integer imageHeight;
    String imageURL;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getEditContent() {
        return editContent;
    }

    public void setEditContent(String editContent) {
        this.editContent = editContent;
    }

    public Integer getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(Integer imageWidth) {
        this.imageWidth = imageWidth;
    }

    public Integer getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(Integer imageHeight) {
        this.imageHeight = imageHeight;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
