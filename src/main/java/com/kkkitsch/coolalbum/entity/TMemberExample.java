package com.kkkitsch.coolalbum.entity;

import java.util.ArrayList;
import java.util.List;

public class TMemberExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TMemberExample() {
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

        public Criteria andMAccountnameIsNull() {
            addCriterion("m_accountname is null");
            return (Criteria) this;
        }

        public Criteria andMAccountnameIsNotNull() {
            addCriterion("m_accountname is not null");
            return (Criteria) this;
        }

        public Criteria andMAccountnameEqualTo(String value) {
            addCriterion("m_accountname =", value, "mAccountname");
            return (Criteria) this;
        }

        public Criteria andMAccountnameNotEqualTo(String value) {
            addCriterion("m_accountname <>", value, "mAccountname");
            return (Criteria) this;
        }

        public Criteria andMAccountnameGreaterThan(String value) {
            addCriterion("m_accountname >", value, "mAccountname");
            return (Criteria) this;
        }

        public Criteria andMAccountnameGreaterThanOrEqualTo(String value) {
            addCriterion("m_accountname >=", value, "mAccountname");
            return (Criteria) this;
        }

        public Criteria andMAccountnameLessThan(String value) {
            addCriterion("m_accountname <", value, "mAccountname");
            return (Criteria) this;
        }

        public Criteria andMAccountnameLessThanOrEqualTo(String value) {
            addCriterion("m_accountname <=", value, "mAccountname");
            return (Criteria) this;
        }

        public Criteria andMAccountnameLike(String value) {
            addCriterion("m_accountname like", value, "mAccountname");
            return (Criteria) this;
        }

        public Criteria andMAccountnameNotLike(String value) {
            addCriterion("m_accountname not like", value, "mAccountname");
            return (Criteria) this;
        }

        public Criteria andMAccountnameIn(List<String> values) {
            addCriterion("m_accountname in", values, "mAccountname");
            return (Criteria) this;
        }

        public Criteria andMAccountnameNotIn(List<String> values) {
            addCriterion("m_accountname not in", values, "mAccountname");
            return (Criteria) this;
        }

        public Criteria andMAccountnameBetween(String value1, String value2) {
            addCriterion("m_accountname between", value1, value2, "mAccountname");
            return (Criteria) this;
        }

        public Criteria andMAccountnameNotBetween(String value1, String value2) {
            addCriterion("m_accountname not between", value1, value2, "mAccountname");
            return (Criteria) this;
        }

        public Criteria andMNicknameIsNull() {
            addCriterion("m_nickname is null");
            return (Criteria) this;
        }

        public Criteria andMNicknameIsNotNull() {
            addCriterion("m_nickname is not null");
            return (Criteria) this;
        }

        public Criteria andMNicknameEqualTo(String value) {
            addCriterion("m_nickname =", value, "mNickname");
            return (Criteria) this;
        }

        public Criteria andMNicknameNotEqualTo(String value) {
            addCriterion("m_nickname <>", value, "mNickname");
            return (Criteria) this;
        }

        public Criteria andMNicknameGreaterThan(String value) {
            addCriterion("m_nickname >", value, "mNickname");
            return (Criteria) this;
        }

        public Criteria andMNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("m_nickname >=", value, "mNickname");
            return (Criteria) this;
        }

        public Criteria andMNicknameLessThan(String value) {
            addCriterion("m_nickname <", value, "mNickname");
            return (Criteria) this;
        }

        public Criteria andMNicknameLessThanOrEqualTo(String value) {
            addCriterion("m_nickname <=", value, "mNickname");
            return (Criteria) this;
        }

        public Criteria andMNicknameLike(String value) {
            addCriterion("m_nickname like", value, "mNickname");
            return (Criteria) this;
        }

        public Criteria andMNicknameNotLike(String value) {
            addCriterion("m_nickname not like", value, "mNickname");
            return (Criteria) this;
        }

        public Criteria andMNicknameIn(List<String> values) {
            addCriterion("m_nickname in", values, "mNickname");
            return (Criteria) this;
        }

        public Criteria andMNicknameNotIn(List<String> values) {
            addCriterion("m_nickname not in", values, "mNickname");
            return (Criteria) this;
        }

        public Criteria andMNicknameBetween(String value1, String value2) {
            addCriterion("m_nickname between", value1, value2, "mNickname");
            return (Criteria) this;
        }

        public Criteria andMNicknameNotBetween(String value1, String value2) {
            addCriterion("m_nickname not between", value1, value2, "mNickname");
            return (Criteria) this;
        }

        public Criteria andMPasswordIsNull() {
            addCriterion("m_password is null");
            return (Criteria) this;
        }

        public Criteria andMPasswordIsNotNull() {
            addCriterion("m_password is not null");
            return (Criteria) this;
        }

        public Criteria andMPasswordEqualTo(String value) {
            addCriterion("m_password =", value, "mPassword");
            return (Criteria) this;
        }

        public Criteria andMPasswordNotEqualTo(String value) {
            addCriterion("m_password <>", value, "mPassword");
            return (Criteria) this;
        }

        public Criteria andMPasswordGreaterThan(String value) {
            addCriterion("m_password >", value, "mPassword");
            return (Criteria) this;
        }

        public Criteria andMPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("m_password >=", value, "mPassword");
            return (Criteria) this;
        }

        public Criteria andMPasswordLessThan(String value) {
            addCriterion("m_password <", value, "mPassword");
            return (Criteria) this;
        }

        public Criteria andMPasswordLessThanOrEqualTo(String value) {
            addCriterion("m_password <=", value, "mPassword");
            return (Criteria) this;
        }

        public Criteria andMPasswordLike(String value) {
            addCriterion("m_password like", value, "mPassword");
            return (Criteria) this;
        }

        public Criteria andMPasswordNotLike(String value) {
            addCriterion("m_password not like", value, "mPassword");
            return (Criteria) this;
        }

        public Criteria andMPasswordIn(List<String> values) {
            addCriterion("m_password in", values, "mPassword");
            return (Criteria) this;
        }

        public Criteria andMPasswordNotIn(List<String> values) {
            addCriterion("m_password not in", values, "mPassword");
            return (Criteria) this;
        }

        public Criteria andMPasswordBetween(String value1, String value2) {
            addCriterion("m_password between", value1, value2, "mPassword");
            return (Criteria) this;
        }

        public Criteria andMPasswordNotBetween(String value1, String value2) {
            addCriterion("m_password not between", value1, value2, "mPassword");
            return (Criteria) this;
        }

        public Criteria andMEmailIsNull() {
            addCriterion("m_email is null");
            return (Criteria) this;
        }

        public Criteria andMEmailIsNotNull() {
            addCriterion("m_email is not null");
            return (Criteria) this;
        }

        public Criteria andMEmailEqualTo(String value) {
            addCriterion("m_email =", value, "mEmail");
            return (Criteria) this;
        }

        public Criteria andMEmailNotEqualTo(String value) {
            addCriterion("m_email <>", value, "mEmail");
            return (Criteria) this;
        }

        public Criteria andMEmailGreaterThan(String value) {
            addCriterion("m_email >", value, "mEmail");
            return (Criteria) this;
        }

        public Criteria andMEmailGreaterThanOrEqualTo(String value) {
            addCriterion("m_email >=", value, "mEmail");
            return (Criteria) this;
        }

        public Criteria andMEmailLessThan(String value) {
            addCriterion("m_email <", value, "mEmail");
            return (Criteria) this;
        }

        public Criteria andMEmailLessThanOrEqualTo(String value) {
            addCriterion("m_email <=", value, "mEmail");
            return (Criteria) this;
        }

        public Criteria andMEmailLike(String value) {
            addCriterion("m_email like", value, "mEmail");
            return (Criteria) this;
        }

        public Criteria andMEmailNotLike(String value) {
            addCriterion("m_email not like", value, "mEmail");
            return (Criteria) this;
        }

        public Criteria andMEmailIn(List<String> values) {
            addCriterion("m_email in", values, "mEmail");
            return (Criteria) this;
        }

        public Criteria andMEmailNotIn(List<String> values) {
            addCriterion("m_email not in", values, "mEmail");
            return (Criteria) this;
        }

        public Criteria andMEmailBetween(String value1, String value2) {
            addCriterion("m_email between", value1, value2, "mEmail");
            return (Criteria) this;
        }

        public Criteria andMEmailNotBetween(String value1, String value2) {
            addCriterion("m_email not between", value1, value2, "mEmail");
            return (Criteria) this;
        }

        public Criteria andMPhoneIsNull() {
            addCriterion("m_phone is null");
            return (Criteria) this;
        }

        public Criteria andMPhoneIsNotNull() {
            addCriterion("m_phone is not null");
            return (Criteria) this;
        }

        public Criteria andMPhoneEqualTo(String value) {
            addCriterion("m_phone =", value, "mPhone");
            return (Criteria) this;
        }

        public Criteria andMPhoneNotEqualTo(String value) {
            addCriterion("m_phone <>", value, "mPhone");
            return (Criteria) this;
        }

        public Criteria andMPhoneGreaterThan(String value) {
            addCriterion("m_phone >", value, "mPhone");
            return (Criteria) this;
        }

        public Criteria andMPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("m_phone >=", value, "mPhone");
            return (Criteria) this;
        }

        public Criteria andMPhoneLessThan(String value) {
            addCriterion("m_phone <", value, "mPhone");
            return (Criteria) this;
        }

        public Criteria andMPhoneLessThanOrEqualTo(String value) {
            addCriterion("m_phone <=", value, "mPhone");
            return (Criteria) this;
        }

        public Criteria andMPhoneLike(String value) {
            addCriterion("m_phone like", value, "mPhone");
            return (Criteria) this;
        }

        public Criteria andMPhoneNotLike(String value) {
            addCriterion("m_phone not like", value, "mPhone");
            return (Criteria) this;
        }

        public Criteria andMPhoneIn(List<String> values) {
            addCriterion("m_phone in", values, "mPhone");
            return (Criteria) this;
        }

        public Criteria andMPhoneNotIn(List<String> values) {
            addCriterion("m_phone not in", values, "mPhone");
            return (Criteria) this;
        }

        public Criteria andMPhoneBetween(String value1, String value2) {
            addCriterion("m_phone between", value1, value2, "mPhone");
            return (Criteria) this;
        }

        public Criteria andMPhoneNotBetween(String value1, String value2) {
            addCriterion("m_phone not between", value1, value2, "mPhone");
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