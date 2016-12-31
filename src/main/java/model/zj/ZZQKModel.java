package model.zj;

/**
 * Created by GBC on 2016/12/25.
 * @description 质证情况
 */
public class ZZQKModel {
    //是否采信
    private String SFCX;
    //质证理由
    private String ZZLY;
    //提起人
    private String TQR;


    public  ZZQKModel(String SFCX, String ZZLY,String TQR){
        this.setSFCX(SFCX);
        this.setZZLY(ZZLY);
        this.setTQR(TQR);
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

    public String getTQR() {
        return TQR;
    }

    public void setTQR(String TQR) {
        this.TQR = TQR;
    }
}
