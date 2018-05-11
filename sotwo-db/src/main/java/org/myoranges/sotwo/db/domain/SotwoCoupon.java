package org.myoranges.sotwo.db.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class SotwoCoupon {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sotwo_coupon.id
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sotwo_coupon.name
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sotwo_coupon.type_money
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    private BigDecimal typeMoney;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sotwo_coupon.send_type
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    private Byte sendType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sotwo_coupon.min_amount
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    private BigDecimal minAmount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sotwo_coupon.max_amount
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    private BigDecimal maxAmount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sotwo_coupon.min_goods_amount
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    private BigDecimal minGoodsAmount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sotwo_coupon.send_start
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    private LocalDateTime sendStart;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sotwo_coupon.send_end
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    private LocalDateTime sendEnd;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sotwo_coupon.use_start
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    private LocalDateTime useStart;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sotwo_coupon.use_end
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    private LocalDateTime useEnd;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sotwo_coupon.add_time
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    private LocalDateTime addTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sotwo_coupon.deleted
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    private Boolean deleted;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sotwo_coupon.id
     *
     * @return the value of sotwo_coupon.id
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sotwo_coupon.id
     *
     * @param id the value for sotwo_coupon.id
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sotwo_coupon.name
     *
     * @return the value of sotwo_coupon.name
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sotwo_coupon.name
     *
     * @param name the value for sotwo_coupon.name
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sotwo_coupon.type_money
     *
     * @return the value of sotwo_coupon.type_money
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    public BigDecimal getTypeMoney() {
        return typeMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sotwo_coupon.type_money
     *
     * @param typeMoney the value for sotwo_coupon.type_money
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    public void setTypeMoney(BigDecimal typeMoney) {
        this.typeMoney = typeMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sotwo_coupon.send_type
     *
     * @return the value of sotwo_coupon.send_type
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    public Byte getSendType() {
        return sendType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sotwo_coupon.send_type
     *
     * @param sendType the value for sotwo_coupon.send_type
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    public void setSendType(Byte sendType) {
        this.sendType = sendType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sotwo_coupon.min_amount
     *
     * @return the value of sotwo_coupon.min_amount
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    public BigDecimal getMinAmount() {
        return minAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sotwo_coupon.min_amount
     *
     * @param minAmount the value for sotwo_coupon.min_amount
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    public void setMinAmount(BigDecimal minAmount) {
        this.minAmount = minAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sotwo_coupon.max_amount
     *
     * @return the value of sotwo_coupon.max_amount
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    public BigDecimal getMaxAmount() {
        return maxAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sotwo_coupon.max_amount
     *
     * @param maxAmount the value for sotwo_coupon.max_amount
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    public void setMaxAmount(BigDecimal maxAmount) {
        this.maxAmount = maxAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sotwo_coupon.min_goods_amount
     *
     * @return the value of sotwo_coupon.min_goods_amount
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    public BigDecimal getMinGoodsAmount() {
        return minGoodsAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sotwo_coupon.min_goods_amount
     *
     * @param minGoodsAmount the value for sotwo_coupon.min_goods_amount
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    public void setMinGoodsAmount(BigDecimal minGoodsAmount) {
        this.minGoodsAmount = minGoodsAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sotwo_coupon.send_start
     *
     * @return the value of sotwo_coupon.send_start
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    public LocalDateTime getSendStart() {
        return sendStart;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sotwo_coupon.send_start
     *
     * @param sendStart the value for sotwo_coupon.send_start
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    public void setSendStart(LocalDateTime sendStart) {
        this.sendStart = sendStart;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sotwo_coupon.send_end
     *
     * @return the value of sotwo_coupon.send_end
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    public LocalDateTime getSendEnd() {
        return sendEnd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sotwo_coupon.send_end
     *
     * @param sendEnd the value for sotwo_coupon.send_end
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    public void setSendEnd(LocalDateTime sendEnd) {
        this.sendEnd = sendEnd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sotwo_coupon.use_start
     *
     * @return the value of sotwo_coupon.use_start
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    public LocalDateTime getUseStart() {
        return useStart;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sotwo_coupon.use_start
     *
     * @param useStart the value for sotwo_coupon.use_start
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    public void setUseStart(LocalDateTime useStart) {
        this.useStart = useStart;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sotwo_coupon.use_end
     *
     * @return the value of sotwo_coupon.use_end
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    public LocalDateTime getUseEnd() {
        return useEnd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sotwo_coupon.use_end
     *
     * @param useEnd the value for sotwo_coupon.use_end
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    public void setUseEnd(LocalDateTime useEnd) {
        this.useEnd = useEnd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sotwo_coupon.add_time
     *
     * @return the value of sotwo_coupon.add_time
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    public LocalDateTime getAddTime() {
        return addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sotwo_coupon.add_time
     *
     * @param addTime the value for sotwo_coupon.add_time
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    public void setAddTime(LocalDateTime addTime) {
        this.addTime = addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sotwo_coupon.deleted
     *
     * @return the value of sotwo_coupon.deleted
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    public Boolean getDeleted() {
        return deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sotwo_coupon.deleted
     *
     * @param deleted the value for sotwo_coupon.deleted
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_coupon
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", typeMoney=").append(typeMoney);
        sb.append(", sendType=").append(sendType);
        sb.append(", minAmount=").append(minAmount);
        sb.append(", maxAmount=").append(maxAmount);
        sb.append(", minGoodsAmount=").append(minGoodsAmount);
        sb.append(", sendStart=").append(sendStart);
        sb.append(", sendEnd=").append(sendEnd);
        sb.append(", useStart=").append(useStart);
        sb.append(", useEnd=").append(useEnd);
        sb.append(", addTime=").append(addTime);
        sb.append(", deleted=").append(deleted);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_coupon
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SotwoCoupon other = (SotwoCoupon) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getTypeMoney() == null ? other.getTypeMoney() == null : this.getTypeMoney().equals(other.getTypeMoney()))
            && (this.getSendType() == null ? other.getSendType() == null : this.getSendType().equals(other.getSendType()))
            && (this.getMinAmount() == null ? other.getMinAmount() == null : this.getMinAmount().equals(other.getMinAmount()))
            && (this.getMaxAmount() == null ? other.getMaxAmount() == null : this.getMaxAmount().equals(other.getMaxAmount()))
            && (this.getMinGoodsAmount() == null ? other.getMinGoodsAmount() == null : this.getMinGoodsAmount().equals(other.getMinGoodsAmount()))
            && (this.getSendStart() == null ? other.getSendStart() == null : this.getSendStart().equals(other.getSendStart()))
            && (this.getSendEnd() == null ? other.getSendEnd() == null : this.getSendEnd().equals(other.getSendEnd()))
            && (this.getUseStart() == null ? other.getUseStart() == null : this.getUseStart().equals(other.getUseStart()))
            && (this.getUseEnd() == null ? other.getUseEnd() == null : this.getUseEnd().equals(other.getUseEnd()))
            && (this.getAddTime() == null ? other.getAddTime() == null : this.getAddTime().equals(other.getAddTime()))
            && (this.getDeleted() == null ? other.getDeleted() == null : this.getDeleted().equals(other.getDeleted()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_coupon
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getTypeMoney() == null) ? 0 : getTypeMoney().hashCode());
        result = prime * result + ((getSendType() == null) ? 0 : getSendType().hashCode());
        result = prime * result + ((getMinAmount() == null) ? 0 : getMinAmount().hashCode());
        result = prime * result + ((getMaxAmount() == null) ? 0 : getMaxAmount().hashCode());
        result = prime * result + ((getMinGoodsAmount() == null) ? 0 : getMinGoodsAmount().hashCode());
        result = prime * result + ((getSendStart() == null) ? 0 : getSendStart().hashCode());
        result = prime * result + ((getSendEnd() == null) ? 0 : getSendEnd().hashCode());
        result = prime * result + ((getUseStart() == null) ? 0 : getUseStart().hashCode());
        result = prime * result + ((getUseEnd() == null) ? 0 : getUseEnd().hashCode());
        result = prime * result + ((getAddTime() == null) ? 0 : getAddTime().hashCode());
        result = prime * result + ((getDeleted() == null) ? 0 : getDeleted().hashCode());
        return result;
    }

    /**
     * This enum was generated by MyBatis Generator.
     * This enum corresponds to the database table sotwo_coupon
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public enum Column {
        id("id"),
        name("name"),
        typeMoney("type_money"),
        sendType("send_type"),
        minAmount("min_amount"),
        maxAmount("max_amount"),
        minGoodsAmount("min_goods_amount"),
        sendStart("send_start"),
        sendEnd("send_end"),
        useStart("use_start"),
        useEnd("use_end"),
        addTime("add_time"),
        deleted("deleted");

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table sotwo_coupon
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String column;

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table sotwo_coupon
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String value() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table sotwo_coupon
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getValue() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table sotwo_coupon
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        Column(String column) {
            this.column = column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table sotwo_coupon
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String desc() {
            return this.column + " DESC";
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table sotwo_coupon
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String asc() {
            return this.column + " ASC";
        }
    }
}