package com.kkkitsch.coolalbum.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TMessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TMessageExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andMIdIsNull() {
            addCriterion("m_id is null");
            return (Criteria) this;
        }

        public Criteria andMIdIsNotNull() {
            addCriterion("m_id is not null");
            return (Criteria) this;
        }

        public Criteria andMIdEqualTo(Integer value) {
            addCriterion("m_id =", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdNotEqualTo(Integer value) {
            addCriterion("m_id <>", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdGreaterThan(Integer value) {
            addCriterion("m_id >", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("m_id >=", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdLessThan(Integer value) {
            addCriterion("m_id <", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdLessThanOrEqualTo(Integer value) {
            addCriterion("m_id <=", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdIn(List<Integer> values) {
            addCriterion("m_id in", values, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdNotIn(List<Integer> values) {
            addCriterion("m_id not in", values, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdBetween(Integer value1, Integer value2) {
            addCriterion("m_id between", value1, value2, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdNotBetween(Integer value1, Integer value2) {
            addCriterion("m_id not between", value1, value2, "mId");
            return (Criteria) this;
        }

        public Criteria andMCreatetimeIsNull() {
            addCriterion("m_createtime is null");
            return (Criteria) this;
        }

        public Criteria andMCreatetimeIsNotNull() {
            addCriterion("m_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andMCreatetimeEqualTo(Date value) {
            addCriterion("m_createtime =", value, "mCreatetime");
            return (Criteria) this;
        }

        public Criteria andMCreatetimeNotEqualTo(Date value) {
            addCriterion("m_createtime <>", value, "mCreatetime");
            return (Criteria) this;
        }

        public Criteria andMCreatetimeGreaterThan(Date value) {
            addCriterion("m_createtime >", value, "mCreatetime");
            return (Criteria) this;
        }

        public Criteria andMCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("m_createtime >=", value, "mCreatetime");
            return (Criteria) this;
        }

        public Criteria andMCreatetimeLessThan(Date value) {
            addCriterion("m_createtime <", value, "mCreatetime");
            return (Criteria) this;
        }

        public Criteria andMCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("m_createtime <=", value, "mCreatetime");
            return (Criteria) this;
        }

        public Criteria andMCreatetimeIn(List<Date> values) {
            addCriterion("m_createtime in", values, "mCreatetime");
            return (Criteria) this;
        }

        public Criteria andMCreatetimeNotIn(List<Date> values) {
            addCriterion("m_createtime not in", values, "mCreatetime");
            return (Criteria) this;
        }

        public Criteria andMCreatetimeBetween(Date value1, Date value2) {
            addCriterion("m_createtime between", value1, value2, "mCreatetime");
            return (Criteria) this;
        }

        public Criteria andMCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("m_createtime not between", value1, value2, "mCreatetime");
            return (Criteria) this;
        }

        public Criteria andMSponsorIsNull() {
            addCriterion("m_sponsor is null");
            return (Criteria) this;
        }

        public Criteria andMSponsorIsNotNull() {
            addCriterion("m_sponsor is not null");
            return (Criteria) this;
        }

        public Criteria andMSponsorEqualTo(String value) {
            addCriterion("m_sponsor =", value, "mSponsor");
            return (Criteria) this;
        }

        public Criteria andMSponsorNotEqualTo(String value) {
            addCriterion("m_sponsor <>", value, "mSponsor");
            return (Criteria) this;
        }

        public Criteria andMSponsorGreaterThan(String value) {
            addCriterion("m_sponsor >", value, "mSponsor");
            return (Criteria) this;
        }

        public Criteria andMSponsorGreaterThanOrEqualTo(String value) {
            addCriterion("m_sponsor >=", value, "mSponsor");
            return (Criteria) this;
        }

        public Criteria andMSponsorLessThan(String value) {
            addCriterion("m_sponsor <", value, "mSponsor");
            return (Criteria) this;
        }

        public Criteria andMSponsorLessThanOrEqualTo(String value) {
            addCriterion("m_sponsor <=", value, "mSponsor");
            return (Criteria) this;
        }

        public Criteria andMSponsorLike(String value) {
            addCriterion("m_sponsor like", value, "mSponsor");
            return (Criteria) this;
        }

        public Criteria andMSponsorNotLike(String value) {
            addCriterion("m_sponsor not like", value, "mSponsor");
            return (Criteria) this;
        }

        public Criteria andMSponsorIn(List<String> values) {
            addCriterion("m_sponsor in", values, "mSponsor");
            return (Criteria) this;
        }

        public Criteria andMSponsorNotIn(List<String> values) {
            addCriterion("m_sponsor not in", values, "mSponsor");
            return (Criteria) this;
        }

        public Criteria andMSponsorBetween(String value1, String value2) {
            addCriterion("m_sponsor between", value1, value2, "mSponsor");
            return (Criteria) this;
        }

        public Criteria andMSponsorNotBetween(String value1, String value2) {
            addCriterion("m_sponsor not between", value1, value2, "mSponsor");
            return (Criteria) this;
        }

        public Criteria andMContentIsNull() {
            addCriterion("m_content is null");
            return (Criteria) this;
        }

        public Criteria andMContentIsNotNull() {
            addCriterion("m_content is not null");
            return (Criteria) this;
        }

        public Criteria andMContentEqualTo(String value) {
            addCriterion("m_content =", value, "mContent");
            return (Criteria) this;
        }

        public Criteria andMContentNotEqualTo(String value) {
            addCriterion("m_content <>", value, "mContent");
            return (Criteria) this;
        }

        public Criteria andMContentGreaterThan(String value) {
            addCriterion("m_content >", value, "mContent");
            return (Criteria) this;
        }

        public Criteria andMContentGreaterThanOrEqualTo(String value) {
            addCriterion("m_content >=", value, "mContent");
            return (Criteria) this;
        }

        public Criteria andMContentLessThan(String value) {
            addCriterion("m_content <", value, "mContent");
            return (Criteria) this;
        }

        public Criteria andMContentLessThanOrEqualTo(String value) {
            addCriterion("m_content <=", value, "mContent");
            return (Criteria) this;
        }

        public Criteria andMContentLike(String value) {
            addCriterion("m_content like", value, "mContent");
            return (Criteria) this;
        }

        public Criteria andMContentNotLike(String value) {
            addCriterion("m_content not like", value, "mContent");
            return (Criteria) this;
        }

        public Criteria andMContentIn(List<String> values) {
            addCriterion("m_content in", values, "mContent");
            return (Criteria) this;
        }

        public Criteria andMContentNotIn(List<String> values) {
            addCriterion("m_content not in", values, "mContent");
            return (Criteria) this;
        }

        public Criteria andMContentBetween(String value1, String value2) {
            addCriterion("m_content between", value1, value2, "mContent");
            return (Criteria) this;
        }

        public Criteria andMContentNotBetween(String value1, String value2) {
            addCriterion("m_content not between", value1, value2, "mContent");
            return (Criteria) this;
        }

        public Criteria andMReplyIdIsNull() {
            addCriterion("m_reply_id is null");
            return (Criteria) this;
        }

        public Criteria andMReplyIdIsNotNull() {
            addCriterion("m_reply_id is not null");
            return (Criteria) this;
        }

        public Criteria andMReplyIdEqualTo(Integer value) {
            addCriterion("m_reply_id =", value, "mReplyId");
            return (Criteria) this;
        }

        public Criteria andMReplyIdNotEqualTo(Integer value) {
            addCriterion("m_reply_id <>", value, "mReplyId");
            return (Criteria) this;
        }

        public Criteria andMReplyIdGreaterThan(Integer value) {
            addCriterion("m_reply_id >", value, "mReplyId");
            return (Criteria) this;
        }

        public Criteria andMReplyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("m_reply_id >=", value, "mReplyId");
            return (Criteria) this;
        }

        public Criteria andMReplyIdLessThan(Integer value) {
            addCriterion("m_reply_id <", value, "mReplyId");
            return (Criteria) this;
        }

        public Criteria andMReplyIdLessThanOrEqualTo(Integer value) {
            addCriterion("m_reply_id <=", value, "mReplyId");
            return (Criteria) this;
        }

        public Criteria andMReplyIdIn(List<Integer> values) {
            addCriterion("m_reply_id in", values, "mReplyId");
            return (Criteria) this;
        }

        public Criteria andMReplyIdNotIn(List<Integer> values) {
            addCriterion("m_reply_id not in", values, "mReplyId");
            return (Criteria) this;
        }

        public Criteria andMReplyIdBetween(Integer value1, Integer value2) {
            addCriterion("m_reply_id between", value1, value2, "mReplyId");
            return (Criteria) this;
        }

        public Criteria andMReplyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("m_reply_id not between", value1, value2, "mReplyId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}