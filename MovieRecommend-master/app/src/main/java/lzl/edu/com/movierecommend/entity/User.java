package lzl.edu.com.movierecommend.entity;

/**
 * Created by admin on 2016/1/9.
 * 用户信息。
 * 用户可以发布评论
 * 用户发布多条评论，一对多的关系。
 */
public class User {
    private String userid;
    //头像
    private Integer nickImage;
    //头像资源
    //昵称
    private String nickName;
    //等级
    private String userMember;
    //唯一识别用户的id
    private String id;
    private String province;
    private String headImg;
    private String userphone;

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Integer getNickImage() {
        return nickImage;
    }

    public void setNickImage(Integer nickImage) {
        this.nickImage = nickImage;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserMember() {
        return userMember;
    }

    public void setUserMember(String userMember) {
        this.userMember = userMember;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!nickName.equals(user.nickName)) return false;
        return id.equals(user.id);

    }

    @Override
    public int hashCode() {
        int result = nickName.hashCode();
        result = 31 * result + id.hashCode();
        return result;
    }
}
