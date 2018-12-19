package com.kkkitsch.coolalbum.entity;

import java.util.ArrayList;
import java.util.List;

public class TFriendExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TFriendExample() {
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

        public Criteria andFIdIsNull() {
            addCriterion("f_id is null");
            return (Criteria) this;
        }

        public Criteria andFIdIsNotNull() {
            addCriterion("f_id is not null");
            return (Criteria) this;
        }

        public Criteria andFIdEqualTo(Integer value) {
            addCriterion("f_id =", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdNotEqualTo(Integer value) {
            addCriterion("f_id <>", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdGreaterThan(Integer value) {
            addCriterion("f_id >", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_id >=", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdLessThan(Integer value) {
            addCriterion("f_id <", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdLessThanOrEqualTo(Integer value) {
            addCriterion("f_id <=", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdIn(List<Integer> values) {
            addCriterion("f_id in", values, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdNotIn(List<Integer> values) {
            addCriterion("f_id not in", values, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdBetween(Integer value1, Integer value2) {
            addCriterion("f_id between", value1, value2, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdNotBetween(Integer value1, Integer value2) {
            addCriterion("f_id not between", value1, value2, "fId");
            return (Criteria) this;
        }

        public Criteria andFMemberidIsNull() {
            addCriterion("f_memberid is null");
            return (Criteria) this;
        }

        public Criteria andFMemberidIsNotNull() {
            addCriterion("f_memberid is not null");
            return (Criteria) this;
        }

        public Criteria andFMemberidEqualTo(Integer value) {
            addCriterion("f_memberid =", value, "fMemberid");
            return (Criteria) this;
        }

        public Criteria andFMemberidNotEqualTo(Integer value) {
            addCriterion("f_memberid <>", value, "fMemberid");
            return (Criteria) this;
        }

        public Criteria andFMemberidGreaterThan(Integer value) {
            addCriterion("f_memberid >", value, "fMemberid");
            return (Criteria) this;
        }

        public Criteria andFMemberidGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_memberid >=", value, "fMemberid");
            return (Criteria) this;
        }

        public Criteria andFMemberidLessThan(Integer value) {
            addCriterion("f_memberid <", value, "fMemberid");
            return (Criteria) this;
        }

        public Criteria andFMemberidLessThanOrEqualTo(Integer value) {
            addCriterion("f_memberid <=", value, "fMemberid");
            return (Criteria) this;
        }

        public Criteria andFMemberidIn(List<Integer> values) {
            addCriterion("f_memberid in", values, "fMemberid");
            return (Criteria) this;
        }

        public Criteria andFMemberidNotIn(List<Integer> values) {
            addCriterion("f_memberid not in", values, "fMemberid");
            return (Criteria) this;
        }

        public Criteria andFMemberidBetween(Integer value1, Integer value2) {
            addCriterion("f_memberid between", value1, value2, "fMemberid");
            return (Criteria) this;
        }

        public Criteria andFMemberidNotBetween(Integer value1, Integer value2) {
            addCriterion("f_memberid not between", value1, value2, "fMemberid");
            return (Criteria) this;
        }

        public Criteria andFFriendacctIsNull() {
            addCriterion("f_friendacct is null");
            return (Criteria) this;
        }

        public Criteria andFFriendacctIsNotNull() {
            addCriterion("f_friendacct is not null");
            return (Criteria) this;
        }

        public Criteria andFFriendacctEqualTo(String value) {
            addCriterion("f_friendacct =", value, "fFriendacct");
            return (Criteria) this;
        }

        public Criteria andFFriendacctNotEqualTo(String value) {
            addCriterion("f_friendacct <>", value, "fFriendacct");
            return (Criteria) this;
        }

        public Criteria andFFriendacctGreaterThan(String value) {
            addCriterion("f_friendacct >", value, "fFriendacct");
            return (Criteria) this;
        }

        public Criteria andFFriendacctGreaterThanOrEqualTo(String value) {
            addCriterion("f_friendacct >=", value, "fFriendacct");
            return (Criteria) this;
        }

        public Criteria andFFriendacctLessThan(String value) {
            addCriterion("f_friendacct <", value, "fFriendacct");
            return (Criteria) this;
        }

        public Criteria andFFriendacctLessThanOrEqualTo(String value) {
            addCriterion("f_friendacct <=", value, "fFriendacct");
            return (Criteria) this;
        }

        public Criteria andFFriendacctLike(String value) {
            addCriterion("f_friendacct like", value, "fFriendacct");
            return (Criteria) this;
        }

        public Criteria andFFriendacctNotLike(String value) {
            addCriterion("f_friendacct not like", value, "fFriendacct");
            return (Criteria) this;
        }

        public Criteria andFFriendacctIn(List<String> values) {
            addCriterion("f_friendacct in", values, "fFriendacct");
            return (Criteria) this;
        }

        public Criteria andFFriendacctNotIn(List<String> values) {
            addCriterion("f_friendacct not in", values, "fFriendacct");
            return (Criteria) this;
        }

        public Criteria andFFriendacctBetween(String value1, String value2) {
            addCriterion("f_friendacct between", value1, value2, "fFriendacct");
            return (Criteria) this;
        }

        public Criteria andFFriendacctNotBetween(String value1, String value2) {
            addCriterion("f_friendacct not between", value1, value2, "fFriendacct");
            return (Criteria) this;
        }

        public Criteria andFFriendidIsNull() {
            addCriterion("f_friendid is null");
            return (Criteria) this;
        }

        public Criteria andFFriendidIsNotNull() {
            addCriterion("f_friendid is not null");
            return (Criteria) this;
        }

        public Criteria andFFriendidEqualTo(Integer value) {
            addCriterion("f_friendid =", value, "fFriendid");
            return (Criteria) this;
        }

        public Criteria andFFriendidNotEqualTo(Integer value) {
            addCriterion("f_friendid <>", value, "fFriendid");
            return (Criteria) this;
        }

        public Criteria andFFriendidGreaterThan(Integer value) {
            addCriterion("f_friendid >", value, "fFriendid");
            return (Criteria) this;
        }

        public Criteria andFFriendidGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_friendid >=", value, "fFriendid");
            return (Criteria) this;
        }

        public Criteria andFFriendidLessThan(Integer value) {
            addCriterion("f_friendid <", value, "fFriendid");
            return (Criteria) this;
        }

        public Criteria andFFriendidLessThanOrEqualTo(Integer value) {
            addCriterion("f_friendid <=", value, "fFriendid");
            return (Criteria) this;
        }

        public Criteria andFFriendidIn(List<Integer> values) {
            addCriterion("f_friendid in", values, "fFriendid");
            return (Criteria) this;
        }

        public Criteria andFFriendidNotIn(List<Integer> values) {
            addCriterion("f_friendid not in", values, "fFriendid");
            return (Criteria) this;
        }

        public Criteria andFFriendidBetween(Integer value1, Integer value2) {
            addCriterion("f_friendid between", value1, value2, "fFriendid");
            return (Criteria) this;
        }

        public Criteria andFFriendidNotBetween(Integer value1, Integer value2) {
            addCriterion("f_friendid not between", value1, value2, "fFriendid");
            return (Criteria) this;
        }

        public Criteria andFNamedfriendIsNull() {
            addCriterion("f_namedfriend is null");
            return (Criteria) this;
        }

        public Criteria andFNamedfriendIsNotNull() {
            addCriterion("f_namedfriend is not null");
            return (Criteria) this;
        }

        public Criteria andFNamedfriendEqualTo(String value) {
            addCriterion("f_namedfriend =", value, "fNamedfriend");
            return (Criteria) this;
        }

        public Criteria andFNamedfriendNotEqualTo(String value) {
            addCriterion("f_namedfriend <>", value, "fNamedfriend");
            return (Criteria) this;
        }

        public Criteria andFNamedfriendGreaterThan(String value) {
            addCriterion("f_namedfriend >", value, "fNamedfriend");
            return (Criteria) this;
        }

        public Criteria andFNamedfriendGreaterThanOrEqualTo(String value) {
            addCriterion("f_namedfriend >=", value, "fNamedfriend");
            return (Criteria) this;
        }

        public Criteria andFNamedfriendLessThan(String value) {
            addCriterion("f_namedfriend <", value, "fNamedfriend");
            return (Criteria) this;
        }

        public Criteria andFNamedfriendLessThanOrEqualTo(String value) {
            addCriterion("f_namedfriend <=", value, "fNamedfriend");
            return (Criteria) this;
        }

        public Criteria andFNamedfriendLike(String value) {
            addCriterion("f_namedfriend like", value, "fNamedfriend");
            return (Criteria) this;
        }

        public Criteria andFNamedfriendNotLike(String value) {
            addCriterion("f_namedfriend not like", value, "fNamedfriend");
            return (Criteria) this;
        }

        public Criteria andFNamedfriendIn(List<String> values) {
            addCriterion("f_namedfriend in", values, "fNamedfriend");
            return (Criteria) this;
        }

        public Criteria andFNamedfriendNotIn(List<String> values) {
            addCriterion("f_namedfriend not in", values, "fNamedfriend");
            return (Criteria) this;
        }

        public Criteria andFNamedfriendBetween(String value1, String value2) {
            addCriterion("f_namedfriend between", value1, value2, "fNamedfriend");
            return (Criteria) this;
        }

        public Criteria andFNamedfriendNotBetween(String value1, String value2) {
            addCriterion("f_namedfriend not between", value1, value2, "fNamedfriend");
            return (Criteria) this;
        }

        public Criteria andFIsblackIsNull() {
            addCriterion("f_isblack is null");
            return (Criteria) this;
        }

        public Criteria andFIsblackIsNotNull() {
            addCriterion("f_isblack is not null");
            return (Criteria) this;
        }

        public Criteria andFIsblackEqualTo(String value) {
            addCriterion("f_isblack =", value, "fIsblack");
            return (Criteria) this;
        }

        public Criteria andFIsblackNotEqualTo(String value) {
            addCriterion("f_isblack <>", value, "fIsblack");
            return (Criteria) this;
        }

        public Criteria andFIsblackGreaterThan(String value) {
            addCriterion("f_isblack >", value, "fIsblack");
            return (Criteria) this;
        }

        public Criteria andFIsblackGreaterThanOrEqualTo(String value) {
            addCriterion("f_isblack >=", value, "fIsblack");
            return (Criteria) this;
        }

        public Criteria andFIsblackLessThan(String value) {
            addCriterion("f_isblack <", value, "fIsblack");
            return (Criteria) this;
        }

        public Criteria andFIsblackLessThanOrEqualTo(String value) {
            addCriterion("f_isblack <=", value, "fIsblack");
            return (Criteria) this;
        }

        public Criteria andFIsblackLike(String value) {
            addCriterion("f_isblack like", value, "fIsblack");
            return (Criteria) this;
        }

        public Criteria andFIsblackNotLike(String value) {
            addCriterion("f_isblack not like", value, "fIsblack");
            return (Criteria) this;
        }

        public Criteria andFIsblackIn(List<String> values) {
            addCriterion("f_isblack in", values, "fIsblack");
            return (Criteria) this;
        }

        public Criteria andFIsblackNotIn(List<String> values) {
            addCriterion("f_isblack not in", values, "fIsblack");
            return (Criteria) this;
        }

        public Criteria andFIsblackBetween(String value1, String value2) {
            addCriterion("f_isblack between", value1, value2, "fIsblack");
            return (Criteria) this;
        }

        public Criteria andFIsblackNotBetween(String value1, String value2) {
            addCriterion("f_isblack not between", value1, value2, "fIsblack");
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