package com.sophimp.award.bean

/**
 * 奖励数据
 */
data class AwardItem(
    /**
     * 名称
     */
    var name: String,

    /**
     * 标识
     */
    var typeId: String,

    /**
     * 分值
     */
    var score: Int,

    /**
     * 动效路径
     */
    var effectAnimation: String
)