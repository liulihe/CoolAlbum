package com.kkkitsch.coolalbum.entity;

import java.util.ArrayList;
import java.util.List;

public class TPhototypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TPhototypeExample() {
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

        public Criteria andPIdIsNull() {
            addCriterion("p_id is null");
            return (Criteria) this;
        }

        public Criteria andPIdIsNotNull() {
            addCriterion("p_id is not null");
            return (Criteria) this;
        }

        public Criteria andPIdEqualTo(Integer value) {
            addCriterion("p_id =", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotEqualTo(Integer value) {
            addCriterion("p_id <>", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdGreaterThan(Integer value) {
            addCriterion("p_id >", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_id >=", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLessThan(Integer value) {
            addCriterion("p_id <", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLessThanOrEqualTo(Integer value) {
            addCriterion("p_id <=", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdIn(List<Integer> values) {
            addCriterion("p_id in", values, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotIn(List<Integer> values) {
            addCriterion("p_id not in", values, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdBetween(Integer value1, Integer value2) {
            addCriterion("p_id between", value1, value2, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotBetween(Integer value1, Integer value2) {
            addCriterion("p_id not between", value1, value2, "pId");
            return (Criteria) this;
        }

        public Criteria andPTypenameIsNull() {
            addCriterion("p_typename is null");
            return (Criteria) this;
        }

        public Criteria andPTypenameIsNotNull() {
            addCriterion("p_typename is not null");
            return (Criteria) this;
        }

        public Criteria andPTypenameEqualTo(String value) {
            addCriterion("p_typename =", value, "pTypename");
            return (Criteria) this;
        }

        public Criteria andPTypenameNotEqualTo(String value) {
            addCriterion("p_typename <>", value, "pTypename");
            return (Criteria) this;
        }

        public Criteria andPTypenameGreaterThan(String value) {
            addCriterion("p_typename >", value, "pTypename");
            return (Criteria) this;
        }

        public Criteria andPTypenameGreaterThanOrEqualTo(String value) {
            addCriterion("p_typename >=", value, "pTypename");
            return (Criteria) this;
        }

        public Criteria andPTypenameLessThan(String value) {
            addCriterion("p_typename <", value, "pTypename");
            return (Criteria) this;
        }

        public Criteria andPTypenameLessThanOrEqualTo(String value) {
            addCriterion("p_typename <=", value, "pTypename");
            return (Criteria) this;
        }

        public Criteria andPTypenameLike(String value) {
            addCriterion("p_typename like", value, "pTypename");
            return (Criteria) this;
        }

        public Criteria andPTypenameNotLike(String value) {
            addCriterion("p_typename not like", value, "pTypename");
            return (Criteria) this;
        }

        public Criteria andPTypenameIn(List<String> values) {
            addCriterion("p_typename in", values, "pTypename");
            return (Criteria) this;
        }

        public Criteria andPTypenameNotIn(List<String> values) {
            addCriterion("p_typename not in", values, "pTypename");
            return (Criteria) this;
        }

        public Criteria andPTypenameBetween(String value1, String value2) {
            addCriterion("p_typename between", value1, value2, "pTypename");
            return (Criteria) this;
        }

        public Criteria andPTypenameNotBetween(String value1, String value2) {
            addCriterion("p_typename not between", value1, value2, "pTypename");
            return (Criteria) this;
        }

        public Criteria andPMemberIdIsNull() {
            addCriterion("p_member_id is null");
            return (Criteria) this;
        }

        public Criteria andPMemberIdIsNotNull() {
            addCriterion("p_member_id is not null");
            return (Criteria) this;
        }

        public Criteria andPMemberIdEqualTo(Integer value) {
            addCriterion("p_member_id =", value, "pMemberId");
            return (Criteria) this;
        }

        public Criteria andPMemberIdNotEqualTo(Integer value) {
            addCriterion("p_member_id <>", value, "pMemberId");
            return (Criteria) this;
        }

        public Criteria andPMemberIdGreaterThan(Integer value) {
            addCriterion("p_member_id >", value, "pMemberId");
            return (Criteria) this;
        }

        public Criteria andPMemberIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_member_id >=", value, "pMemberId");
            return (Criteria) this;
        }

        public Criteria andPMemberIdLessThan(Integer value) {
            addCriterion("p_member_id <", value, "pMemberId");
            return (Criteria) this;
        }

        public Criteria andPMemberIdLessThanOrEqualTo(Integer value) {
            addCriterion("p_member_id <=", value, "pMemberId");
            return (Criteria) this;
        }

        public Criteria andPMemberIdIn(List<Integer> values) {
            addCriterion("p_member_id in", values, "pMemberId");
            return (Criteria) this;
        }

        public Criteria andPMemberIdNotIn(List<Integer> values) {
            addCriterion("p_member_id not in", values, "pMemberId");
            return (Criteria) this;
        }

        public Criteria andPMemberIdBetween(Integer value1, Integer value2) {
            addCriterion("p_member_id between", value1, value2, "pMemberId");
            return (Criteria) this;
        }

        public Criteria andPMemberIdNotBetween(Integer value1, Integer value2) {
            addCriterion("p_member_id not between", value1, value2, "pMemberId");
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