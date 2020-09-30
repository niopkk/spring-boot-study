package com.bbz;


import java.util.List;
import java.util.stream.Collectors;

/**
 * 分类
 * <p>
 * Created by ranhepeng on 04/04/2018.
 */
public enum UnitCategory {
    A0("烟感"),
    A1("门磁"),
    A2("高空抛物"),
    A3("红外周界"),
    A4("电梯传感器"),
    A5("二次供水"),
    A6("燃气传感器"),
    A7("智能井盖"),
    A8("智能水表"),
    A9("厕所异味监测"),
    AA("智能垃圾箱"),
    AB("喷淋末端水压"),
    AC("通道堆物探测"),
    AD("常闭式防火门检测"),
    AE("智能消防栓"),
    AF("消防通道地磁"),
    AG("地磁"),
    AH("区域灰尘传感器"),
    AI("温湿度传感器"),
    AJ("智能充电车棚"),
    AK("水箱水盖"),
    AL("电弧灭弧保护器"),//ElectricArcProtector
    AM("充电桩"),//ChargingPileData
    AN("人体红外感应"),//HumanInfrared
    AO("PH传感器"),//PhSensor
    AP("溶解氧传感器"),//DissolvedOxygen
    AQ("智能电表"),
    AR("智能路灯"),
    AS("燃气监测"),
    AT("环境监测"),
    AU("水质监测"),
    AV("窗磁"),
    AW("垃圾追踪"),
    AX("水浸传感器"),
    AY("水箱盖开合检测倾角传感器"),
    AZ("地下管网"),

    Z0("红外微波探测器"),
    Z1("智能定位器"),
    Z2("感温火灾探测器"),
    Z3("应急照明"),
    Z4("消火栓按钮"),
    Z5("信号阀"),
    Z6("声光报警器"),
    Z7("消防广播"),
    Z8("手动火灾报警按钮"),
    Z9("防火阀"),
    ZA("水流指示器"),
    ZB("消防泵"),
    ZC("风机"),
    ZD("环境感知"),
    ZE("消防占道"),
    ZF("智能手环"),
    ZG("禁停监测"),
    ZH("停车监测"),
    ZI("防盗"),
    ZJ("水压监测"),
    ZK("电子巡更"),
    ZL("微信开门"),
    ZM("智能车棚"),

    QT("其他"),

    //中海
    B0("高清监控"),
    B1("全景高清监控"),
    B2("标清监控"),
    B3("微卡口监控"),
    B4("小区监控"),
    B5("道路治安卡口"),
    B6("违停抓拍"),
    B7("内部监控"),

    //兆物
    C0("wifi嗅探"),
    //电信
    D0("实时可依靠力量"),
    //天信
    E0("智能门禁"),
    E1("二维码门禁"),
    //公安
    F0("实时警力"),
    F1("110报警"),
    //消防
    G0("消防水箱探测"),
    //海康
    H0("人脸微卡口"),
    H1("车辆微卡口"),
    H2("经营性停车场"),
    H3("多功能"),

    H4("人体识别"),
    H5("路人非机动车违法抓拍"),
    H6("智能信号灯"),

    //杨浦图层
    I0("危化品"),
    I1("综合市场"),
    I2("全区学校"),
    I3("反恐重点目标"),
    I4("贵重商品店（柜）"),
    I5("加油（气）站"),
    I6("城市综合体"),
    I7("小区"),
    I8("重点区域"),
    J0("实有单位"),
    J1("楼宇"),

    //城地
    K0("经营性停车场");

    private String desc;


    UnitCategory(String desc) {
        this.desc = desc;
    }


//    public static void main(String[] args) {
//        for (UnitCategory category : UnitCategory.values()) {
//            System.out.println(String.format("| %s | %s |",category.name(), category.getDesc()));
//        }
//    }
}
