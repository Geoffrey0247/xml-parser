package model;

/**
 * Created by GBC on 2016/12/25.
 * @description 质证情况
 */
public class ZZQKModel {
    //是否采信
    private String SFCX;
    //质证理由
    private String ZZLY;

    public ZZQKModel(){}

    public ZZQKModel(String SFCX, String ZZLY){
        this.setSFCX(SFCX);
        this.setZZLY(ZZLY);
    }

    public ZZQKModel(String SFCX, String ZZLY,String TQR){
        this.setSFCX(SFCX);
        this.setZZLY(ZZLY);
    }


    public String getSFCX() {
        return SFCX;
    }

    public void setSFCX(String SFCX) {
        this.SFCX = SFCX;
    }

    public String getZZLY() {
        return ZZLY;
    }

    public void setZZLY(String ZZLY) {
        this.ZZLY = ZZLY;
    }
}
