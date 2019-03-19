package com.kkkitsch.coolalbum.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TMessageReplyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TMessageReplyExample() {
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

        public Criteria andMIdEqualTo(String value) {
            addCriterion("m_id =", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdNotEqualTo(String value) {
            addCriterion("m_id <>", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdGreaterThan(String value) {
            addCriterion("m_id >", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdGreaterThanOrEqualTo(String value) {
            addCriterion("m_id >=", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdLessThan(String value) {
            addCriterion("m_id <", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdLessThanOrEqualTo(String value) {
            addCriterion("m_id <=", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdLike(String value) {
            addCriterion("m_id like", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdNotLike(String value) {
            addCriterion("m_id not like", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdIn(List<String> values) {
            addCriterion("m_id in", values, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdNotIn(List<String> values) {
            addCriterion("m_id not in", values, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdBetween(String value1, String value2) {
            addCriterion("m_id between", value1, value2, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdNotBetween(String value1, String value2) {
            addCriterion("m_id not between", value1, value2, "mId");
            return (Criteria) this;
        }

        public Criteria andMSponsorAcctIsNull() {
            addCriterion("m_sponsor_acct is null");
            return (Criteria) this;
        }

        public Criteria andMSponsorAcctIsNotNull() {
            addCriterion("m_sponsor_acct is not null");
            return (Criteria) this;
        }

        public Criteria andMSponsorAcctEqualTo(String value) {
            addCriterion("m_sponsor_acct =", value, "mSponsorAcct");
            return (Criteria) this;
        }

        public Criteria andMSponsorAcctNotEqualTo(String value) {
            addCriterion("m_sponsor_acct <>", value, "mSponsorAcct");
            return (Criteria) this;
        }

        public Criteria andMSponsorAcctGreaterThan(String value) {
            addCriterion("m_sponsor_acct >", value, "mSponsorAcct");
            return (Criteria) this;
        }

        public Criteria andMSponsorAcctGreaterThanOrEqualTo(String value) {
            addCriterion("m_sponsor_acct >=", value, "mSponsorAcct");
            return (Criteria) this;
        }

        public Criteria andMSponsorAcctLessThan(String value) {
            addCriterion("m_sponsor_acct <", value, "mSponsorAcct");
            return (Criteria) this;
        }

        public Criteria andMSponsorAcctLessThanOrEqualTo(String value) {
            addCriterion("m_sponsor_acct <=", value, "mSponsorAcct");
            return (Criteria) this;
        }

        public Criteria andMSponsorAcctLike(String value) {
            addCriterion("m_sponsor_acct like", value, "mSponsorAcct");
            return (Criteria) this;
        }

        public Criteria andMSponsorAcctNotLike(String value) {
            addCriterion("m_sponsor_acct not like", value, "mSponsorAcct");
            return (Criteria) this;
        }

        public Criteria andMSponsorAcctIn(List<String> values) {
            addCriterion("m_sponsor_acct in", values, "mSponsorAcct");
            return (Criteria) this;
        }

        public Criteria andMSponsorAcctNotIn(List<String> values) {
            addCriterion("m_sponsor_acct not in", values, "mSponsorAcct");
            return (Criteria) this;
        }

        public Criteria andMSponsorAcctBetween(String value1, String value2) {
            addCriterion("m_sponsor_acct between", value1, value2, "mSponsorAcct");
            return (Criteria) this;
        }

        public Criteria andMSponsorAcctNotBetween(String value1, String value2) {
            addCriterion("m_sponsor_acct not between", value1, value2, "mSponsorAcct");
            return (Criteria) this;
        }

        public Criteria andMReceiverAcctIsNull() {
            addCriterion("m_receiver_acct is null");
            return (Criteria) this;
        }

        public Criteria andMReceiverAcctIsNotNull() {
            addCriterion("m_receiver_acct is not null");
            return (Criteria) this;
        }

        public Criteria andMReceiverAcctEqualTo(String value) {
            addCriterion("m_receiver_acct =", value, "mReceiverAcct");
            return (Criteria) this;
        }

        public Criteria andMReceiverAcctNotEqualTo(String value) {
            addCriterion("m_receiver_acct <>", value, "mReceiverAcct");
            return (Criteria) this;
        }

        public Criteria andMReceiverAcctGreaterThan(String value) {
            addCriterion("m_receiver_acct >", value, "mReceiverAcct");
            return (Criteria) this;
        }

        public Criteria andMReceiverAcctGreaterThanOrEqualTo(String value) {
            addCriterion("m_receiver_acct >=", value, "mReceiverAcct");
            return (Criteria) this;
        }

        public Criteria andMReceiverAcctLessThan(String value) {
            addCriterion("m_receiver_acct <", value, "mReceiverAcct");
            return (Criteria) this;
        }

        public Criteria andMReceiverAcctLessThanOrEqualTo(String value) {
            addCriterion("m_receiver_acct <=", value, "mReceiverAcct");
            return (Criteria) this;
        }

        public Criteria andMReceiverAcctLike(String value) {
            addCriterion("m_receiver_acct like", value, "mReceiverAcct");
            return (Criteria) this;
        }

        public Criteria andMReceiverAcctNotLike(String value) {
            addCriterion("m_receiver_acct not like", value, "mReceiverAcct");
            return (Criteria) this;
        }

        public Criteria andMReceiverAcctIn(List<String> values) {
            addCriterion("m_receiver_acct in", values, "mReceiverAcct");
            return (Criteria) this;
        }

        public Criteria andMReceiverAcctNotIn(List<String> values) {
            addCriterion("m_receiver_acct not in", values, "mReceiverAcct");
            return (Criteria) this;
        }

        public Criteria andMReceiverAcctBetween(String value1, String value2) {
            addCriterion("m_receiver_acct between", value1, value2, "mReceiverAcct");
            return (Criteria) this;
        }

        public Criteria andMReceiverAcctNotBetween(String value1, String value2) {
            addCriterion("m_receiver_acct not between", value1, value2, "mReceiverAcct");
            return (Criteria) this;
        }

        public Criteria andMReplyContentIsNull() {
            addCriterion("m_reply_content is null");
            return (Criteria) this;
        }

        public Criteria andMReplyContentIsNotNull() {
            addCriterion("m_reply_content is not null");
            return (Criteria) this;
        }

        public Criteria andMReplyContentEqualTo(String value) {
            addCriterion("m_reply_content =", value, "mReplyContent");
            return (Criteria) this;
        }

        public Criteria andMReplyContentNotEqualTo(String value) {
            addCriterion("m_reply_content <>", value, "mReplyContent");
            return (Criteria) this;
        }

        public Criteria andMReplyContentGreaterThan(String value) {
            addCriterion("m_reply_content >", value, "mReplyContent");
            return (Criteria) this;
        }

        public Criteria andMReplyContentGreaterThanOrEqualTo(String value) {
            addCriterion("m_reply_content >=", value, "mReplyContent");
            return (Criteria) this;
        }

        public Criteria andMReplyContentLessThan(String value) {
            addCriterion("m_reply_content <", value, "mReplyContent");
            return (Criteria) this;
        }

        public Criteria andMReplyContentLessThanOrEqualTo(String value) {
            addCriterion("m_reply_content <=", value, "mReplyContent");
            return (Criteria) this;
        }

        public Criteria andMReplyContentLike(String value) {
            addCriterion("m_reply_content like", value, "mReplyContent");
            return (Criteria) this;
        }

        public Criteria andMReplyContentNotLike(String value) {
            addCriterion("m_reply_content not like", value, "mReplyContent");
            return (Criteria) this;
        }

        public Criteria andMReplyContentIn(List<String> values) {
            addCriterion("m_reply_content in", values, "mReplyContent");
            return (Criteria) this;
        }

        public Criteria andMReplyContentNotIn(List<String> values) {
            addCriterion("m_reply_content not in", values, "mReplyContent");
            return (Criteria) this;
        }

        public Criteria andMReplyContentBetween(String value1, String value2) {
            addCriterion("m_reply_content between", value1, value2, "mReplyContent");
            return (Criteria) this;
        }

        public Criteria andMReplyContentNotBetween(String value1, String value2) {
            addCriterion("m_reply_content not between", value1, value2, "mReplyContent");
            return (Criteria) this;
        }

        public Criteria andMReplyTimeIsNull() {
            addCriterion("m_reply_time is null");
            return (Criteria) this;
        }

        public Criteria andMReplyTimeIsNotNull() {
            addCriterion("m_reply_time is not null");
            return (Criteria) this;
        }

        public Criteria andMReplyTimeEqualTo(Date value) {
            addCriterion("m_reply_time =", value, "mReplyTime");
            return (Criteria) this;
        }

        public Criteria andMReplyTimeNotEqualTo(Date value) {
            addCriterion("m_reply_time <>", value, "mReplyTime");
            return (Criteria) this;
        }

        public Criteria andMReplyTimeGreaterThan(Date value) {
            addCriterion("m_reply_time >", value, "mReplyTime");
            return (Criteria) this;
        }

        public Criteria andMReplyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("m_reply_time >=", value, "mReplyTime");
            return (Criteria) this;
        }

        public Criteria andMReplyTimeLessThan(Date value) {
            addCriterion("m_reply_time <", value, "mReplyTime");
            return (Criteria) this;
        }

        public Criteria andMReplyTimeLessThanOrEqualTo(Date value) {
            addCriterion("m_reply_time <=", value, "mReplyTime");
            return (Criteria) this;
        }

        public Criteria andMReplyTimeIn(List<Date> values) {
            addCriterion("m_reply_time in", values, "mReplyTime");
            return (Criteria) this;
        }

        public Criteria andMReplyTimeNotIn(List<Date> values) {
            addCriterion("m_reply_time not in", values, "mReplyTime");
            return (Criteria) this;
        }

        public Criteria andMReplyTimeBetween(Date value1, Date value2) {
            addCriterion("m_reply_time between", value1, value2, "mReplyTime");
            return (Criteria) this;
        }

        public Criteria andMReplyTimeNotBetween(Date value1, Date value2) {
            addCriterion("m_reply_time not between", value1, value2, "mReplyTime");
            return (Criteria) this;
        }

        public Criteria andMReplyUpdateTimeIsNull() {
            addCriterion("m_reply_update_time is null");
            return (Criteria) this;
        }

        public Criteria andMReplyUpdateTimeIsNotNull() {
            addCriterion("m_reply_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andMReplyUpdateTimeEqualTo(Date value) {
            addCriterion("m_reply_update_time =", value, "mReplyUpdateTime");
            return (Criteria) this;
        }

        public Criteria andMReplyUpdateTimeNotEqualTo(Date value) {
            addCriterion("m_reply_update_time <>", value, "mReplyUpdateTime");
            return (Criteria) this;
        }

        public Criteria andMReplyUpdateTimeGreaterThan(Date value) {
            addCriterion("m_reply_update_time >", value, "mReplyUpdateTime");
            return (Criteria) this;
        }

        public Criteria andMReplyUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("m_reply_update_time >=", value, "mReplyUpdateTime");
            return (Criteria) this;
        }

        public Criteria andMReplyUpdateTimeLessThan(Date value) {
            addCriterion("m_reply_update_time <", value, "mReplyUpdateTime");
            return (Criteria) this;
        }

        public Criteria andMReplyUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("m_reply_update_time <=", value, "mReplyUpdateTime");
            return (Criteria) this;
        }

        public Criteria andMReplyUpdateTimeIn(List<Date> values) {
            addCriterion("m_reply_update_time in", values, "mReplyUpdateTime");
            return (Criteria) this;
        }

        public Criteria andMReplyUpdateTimeNotIn(List<Date> values) {
            addCriterion("m_reply_update_time not in", values, "mReplyUpdateTime");
            return (Criteria) this;
        }

        public Criteria andMReplyUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("m_reply_update_time between", value1, value2, "mReplyUpdateTime");
            return (Criteria) this;
        }

        public Criteria andMReplyUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("m_reply_update_time not between", value1, value2, "mReplyUpdateTime");
            return (Criteria) this;
        }

        public Criteria andMReplyRefertoIsNull() {
            addCriterion("m_reply_referto is null");
            return (Criteria) this;
        }

        public Criteria andMReplyRefertoIsNotNull() {
            addCriterion("m_reply_referto is not null");
            return (Criteria) this;
        }

        public Criteria andMReplyRefertoEqualTo(String value) {
            addCriterion("m_reply_referto =", value, "mReplyReferto");
            return (Criteria) this;
        }

        public Criteria andMReplyRefertoNotEqualTo(String value) {
            addCriterion("m_reply_referto <>", value, "mReplyReferto");
            return (Criteria) this;
        }

        public Criteria andMReplyRefertoGreaterThan(String value) {
            addCriterion("m_reply_referto >", value, "mReplyReferto");
            return (Criteria) this;
        }

        public Criteria andMReplyRefertoGreaterThanOrEqualTo(String value) {
            addCriterion("m_reply_referto >=", value, "mReplyReferto");
            return (Criteria) this;
        }

        public Criteria andMReplyRefertoLessThan(String value) {
            addCriterion("m_reply_referto <", value, "mReplyReferto");
            return (Criteria) this;
        }

        public Criteria andMReplyRefertoLessThanOrEqualTo(String value) {
            addCriterion("m_reply_referto <=", value, "mReplyReferto");
            return (Criteria) this;
        }

        public Criteria andMReplyRefertoLike(String value) {
            addCriterion("m_reply_referto like", value, "mReplyReferto");
            return (Criteria) this;
        }

        public Criteria andMReplyRefertoNotLike(String value) {
            addCriterion("m_reply_referto not like", value, "mReplyReferto");
            return (Criteria) this;
        }

        public Criteria andMReplyRefertoIn(List<String> values) {
            addCriterion("m_reply_referto in", values, "mReplyReferto");
            return (Criteria) this;
        }

        public Criteria andMReplyRefertoNotIn(List<String> values) {
            addCriterion("m_reply_referto not in", values, "mReplyReferto");
            return (Criteria) this;
        }

        public Criteria andMReplyRefertoBetween(String value1, String value2) {
            addCriterion("m_reply_referto between", value1, value2, "mReplyReferto");
            return (Criteria) this;
        }

        public Criteria andMReplyRefertoNotBetween(String value1, String value2) {
            addCriterion("m_reply_referto not between", value1, value2, "mReplyReferto");
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