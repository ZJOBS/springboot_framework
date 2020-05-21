package jiezhang.console.entity.db;

import jiezhang.base.annotation.Id;
import jiezhang.base.annotation.TableName;
import jiezhang.base.entity.BaseEntity;

@TableName(name = "cq_bill_config")
public class CqBillConfig extends BaseEntity {
    @Id
    private String cqBillConfigId;
    /**
     * 属性
     */
    private String attribute;

    /**
     * 相似词
     */
    private String similarityValue;


    public String getCqBillConfigId() {
        return cqBillConfigId;
    }

    public void setCqBillConfigId(String cqBillConfigId) {
        this.cqBillConfigId = cqBillConfigId;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getSimilarityValue() {
        return similarityValue;
    }

    public void setSimilarityValue(String similarityValue) {
        this.similarityValue = similarityValue;
    }

    @Override
    public String toString() {
        return "CqBillConfig{" +
                "cqBillConfigId='" + cqBillConfigId + '\'' +
                ", attribute='" + attribute + '\'' +
                ", similarityValue='" + similarityValue + '\'' +
                ", createUserName='" + createUserName + '\'' +
                ", updateUserName='" + updateUserName + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", state='" + state + '\'' +
                '}';
    }
}
