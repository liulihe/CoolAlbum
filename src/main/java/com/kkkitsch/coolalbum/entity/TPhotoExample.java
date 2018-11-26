package com.kkkitsch.coolalbum.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TPhotoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TPhotoExample() {
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

        public Criteria andPNameIsNull() {
            addCriterion("p_name is null");
            return (Criteria) this;
        }

        public Criteria andPNameIsNotNull() {
            addCriterion("p_name is not null");
            return (Criteria) this;
        }

        public Criteria andPNameEqualTo(String value) {
            addCriterion("p_name =", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotEqualTo(String value) {
            addCriterion("p_name <>", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameGreaterThan(String value) {
            addCriterion("p_name >", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameGreaterThanOrEqualTo(String value) {
            addCriterion("p_name >=", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameLessThan(String value) {
            addCriterion("p_name <", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameLessThanOrEqualTo(String value) {
            addCriterion("p_name <=", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameLike(String value) {
            addCriterion("p_name like", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotLike(String value) {
            addCriterion("p_name not like", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameIn(List<String> values) {
            addCriterion("p_name in", values, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotIn(List<String> values) {
            addCriterion("p_name not in", values, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameBetween(String value1, String value2) {
            addCriterion("p_name between", value1, value2, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotBetween(String value1, String value2) {
            addCriterion("p_name not between", value1, value2, "pName");
            return (Criteria) this;
        }

        public Criteria andPCreatetimeIsNull() {
            addCriterion("p_createtime is null");
            return (Criteria) this;
        }

        public Criteria andPCreatetimeIsNotNull() {
            addCriterion("p_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andPCreatetimeEqualTo(Date value) {
            addCriterion("p_createtime =", value, "pCreatetime");
            return (Criteria) this;
        }

        public Criteria andPCreatetimeNotEqualTo(Date value) {
            addCriterion("p_createtime <>", value, "pCreatetime");
            return (Criteria) this;
        }

        public Criteria andPCreatetimeGreaterThan(Date value) {
            addCriterion("p_createtime >", value, "pCreatetime");
            return (Criteria) this;
        }

        public Criteria andPCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("p_createtime >=", value, "pCreatetime");
            return (Criteria) this;
        }

        public Criteria andPCreatetimeLessThan(Date value) {
            addCriterion("p_createtime <", value, "pCreatetime");
            return (Criteria) this;
        }

        public Criteria andPCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("p_createtime <=", value, "pCreatetime");
            return (Criteria) this;
        }

        public Criteria andPCreatetimeIn(List<Date> values) {
            addCriterion("p_createtime in", values, "pCreatetime");
            return (Criteria) this;
        }

        public Criteria andPCreatetimeNotIn(List<Date> values) {
            addCriterion("p_createtime not in", values, "pCreatetime");
            return (Criteria) this;
        }

        public Criteria andPCreatetimeBetween(Date value1, Date value2) {
            addCriterion("p_createtime between", value1, value2, "pCreatetime");
            return (Criteria) this;
        }

        public Criteria andPCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("p_createtime not between", value1, value2, "pCreatetime");
            return (Criteria) this;
        }

        public Criteria andPModitytimeIsNull() {
            addCriterion("p_moditytime is null");
            return (Criteria) this;
        }

        public Criteria andPModitytimeIsNotNull() {
            addCriterion("p_moditytime is not null");
            return (Criteria) this;
        }

        public Criteria andPModitytimeEqualTo(Date value) {
            addCriterion("p_moditytime =", value, "pModitytime");
            return (Criteria) this;
        }

        public Criteria andPModitytimeNotEqualTo(Date value) {
            addCriterion("p_moditytime <>", value, "pModitytime");
            return (Criteria) this;
        }

        public Criteria andPModitytimeGreaterThan(Date value) {
            addCriterion("p_moditytime >", value, "pModitytime");
            return (Criteria) this;
        }

        public Criteria andPModitytimeGreaterThanOrEqualTo(Date value) {
            addCriterion("p_moditytime >=", value, "pModitytime");
            return (Criteria) this;
        }

        public Criteria andPModitytimeLessThan(Date value) {
            addCriterion("p_moditytime <", value, "pModitytime");
            return (Criteria) this;
        }

        public Criteria andPModitytimeLessThanOrEqualTo(Date value) {
            addCriterion("p_moditytime <=", value, "pModitytime");
            return (Criteria) this;
        }

        public Criteria andPModitytimeIn(List<Date> values) {
            addCriterion("p_moditytime in", values, "pModitytime");
            return (Criteria) this;
        }

        public Criteria andPModitytimeNotIn(List<Date> values) {
            addCriterion("p_moditytime not in", values, "pModitytime");
            return (Criteria) this;
        }

        public Criteria andPModitytimeBetween(Date value1, Date value2) {
            addCriterion("p_moditytime between", value1, value2, "pModitytime");
            return (Criteria) this;
        }

        public Criteria andPModitytimeNotBetween(Date value1, Date value2) {
            addCriterion("p_moditytime not between", value1, value2, "pModitytime");
            return (Criteria) this;
        }

        public Criteria andPUrlIsNull() {
            addCriterion("p_url is null");
            return (Criteria) this;
        }

        public Criteria andPUrlIsNotNull() {
            addCriterion("p_url is not null");
            return (Criteria) this;
        }

        public Criteria andPUrlEqualTo(String value) {
            addCriterion("p_url =", value, "pUrl");
            return (Criteria) this;
        }

        public Criteria andPUrlNotEqualTo(String value) {
            addCriterion("p_url <>", value, "pUrl");
            return (Criteria) this;
        }

        public Criteria andPUrlGreaterThan(String value) {
            addCriterion("p_url >", value, "pUrl");
            return (Criteria) this;
        }

        public Criteria andPUrlGreaterThanOrEqualTo(String value) {
            addCriterion("p_url >=", value, "pUrl");
            return (Criteria) this;
        }

        public Criteria andPUrlLessThan(String value) {
            addCriterion("p_url <", value, "pUrl");
            return (Criteria) this;
        }

        public Criteria andPUrlLessThanOrEqualTo(String value) {
            addCriterion("p_url <=", value, "pUrl");
            return (Criteria) this;
        }

        public Criteria andPUrlLike(String value) {
            addCriterion("p_url like", value, "pUrl");
            return (Criteria) this;
        }

        public Criteria andPUrlNotLike(String value) {
            addCriterion("p_url not like", value, "pUrl");
            return (Criteria) this;
        }

        public Criteria andPUrlIn(List<String> values) {
            addCriterion("p_url in", values, "pUrl");
            return (Criteria) this;
        }

        public Criteria andPUrlNotIn(List<String> values) {
            addCriterion("p_url not in", values, "pUrl");
            return (Criteria) this;
        }

        public Criteria andPUrlBetween(String value1, String value2) {
            addCriterion("p_url between", value1, value2, "pUrl");
            return (Criteria) this;
        }

        public Criteria andPUrlNotBetween(String value1, String value2) {
            addCriterion("p_url not between", value1, value2, "pUrl");
            return (Criteria) this;
        }

        public Criteria andPDescriptionIsNull() {
            addCriterion("p_description is null");
            return (Criteria) this;
        }

        public Criteria andPDescriptionIsNotNull() {
            addCriterion("p_description is not null");
            return (Criteria) this;
        }

        public Criteria andPDescriptionEqualTo(String value) {
            addCriterion("p_description =", value, "pDescription");
            return (Criteria) this;
        }

        public Criteria andPDescriptionNotEqualTo(String value) {
            addCriterion("p_description <>", value, "pDescription");
            return (Criteria) this;
        }

        public Criteria andPDescriptionGreaterThan(String value) {
            addCriterion("p_description >", value, "pDescription");
            return (Criteria) this;
        }

        public Criteria andPDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("p_description >=", value, "pDescription");
            return (Criteria) this;
        }

        public Criteria andPDescriptionLessThan(String value) {
            addCriterion("p_description <", value, "pDescription");
            return (Criteria) this;
        }

        public Criteria andPDescriptionLessThanOrEqualTo(String value) {
            addCriterion("p_description <=", value, "pDescription");
            return (Criteria) this;
        }

        public Criteria andPDescriptionLike(String value) {
            addCriterion("p_description like", value, "pDescription");
            return (Criteria) this;
        }

        public Criteria andPDescriptionNotLike(String value) {
            addCriterion("p_description not like", value, "pDescription");
            return (Criteria) this;
        }

        public Criteria andPDescriptionIn(List<String> values) {
            addCriterion("p_description in", values, "pDescription");
            return (Criteria) this;
        }

        public Criteria andPDescriptionNotIn(List<String> values) {
            addCriterion("p_description not in", values, "pDescription");
            return (Criteria) this;
        }

        public Criteria andPDescriptionBetween(String value1, String value2) {
            addCriterion("p_description between", value1, value2, "pDescription");
            return (Criteria) this;
        }

        public Criteria andPDescriptionNotBetween(String value1, String value2) {
            addCriterion("p_description not between", value1, value2, "pDescription");
            return (Criteria) this;
        }

        public Criteria andPLikenumIsNull() {
            addCriterion("p_likenum is null");
            return (Criteria) this;
        }

        public Criteria andPLikenumIsNotNull() {
            addCriterion("p_likenum is not null");
            return (Criteria) this;
        }

        public Criteria andPLikenumEqualTo(Integer value) {
            addCriterion("p_likenum =", value, "pLikenum");
            return (Criteria) this;
        }

        public Criteria andPLikenumNotEqualTo(Integer value) {
            addCriterion("p_likenum <>", value, "pLikenum");
            return (Criteria) this;
        }

        public Criteria andPLikenumGreaterThan(Integer value) {
            addCriterion("p_likenum >", value, "pLikenum");
            return (Criteria) this;
        }

        public Criteria andPLikenumGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_likenum >=", value, "pLikenum");
            return (Criteria) this;
        }

        public Criteria andPLikenumLessThan(Integer value) {
            addCriterion("p_likenum <", value, "pLikenum");
            return (Criteria) this;
        }

        public Criteria andPLikenumLessThanOrEqualTo(Integer value) {
            addCriterion("p_likenum <=", value, "pLikenum");
            return (Criteria) this;
        }

        public Criteria andPLikenumIn(List<Integer> values) {
            addCriterion("p_likenum in", values, "pLikenum");
            return (Criteria) this;
        }

        public Criteria andPLikenumNotIn(List<Integer> values) {
            addCriterion("p_likenum not in", values, "pLikenum");
            return (Criteria) this;
        }

        public Criteria andPLikenumBetween(Integer value1, Integer value2) {
            addCriterion("p_likenum between", value1, value2, "pLikenum");
            return (Criteria) this;
        }

        public Criteria andPLikenumNotBetween(Integer value1, Integer value2) {
            addCriterion("p_likenum not between", value1, value2, "pLikenum");
            return (Criteria) this;
        }

        public Criteria andPClicklikeMemberidIsNull() {
            addCriterion("p_clicklike_memberid is null");
            return (Criteria) this;
        }

        public Criteria andPClicklikeMemberidIsNotNull() {
            addCriterion("p_clicklike_memberid is not null");
            return (Criteria) this;
        }

        public Criteria andPClicklikeMemberidEqualTo(String value) {
            addCriterion("p_clicklike_memberid =", value, "pClicklikeMemberid");
            return (Criteria) this;
        }

        public Criteria andPClicklikeMemberidNotEqualTo(String value) {
            addCriterion("p_clicklike_memberid <>", value, "pClicklikeMemberid");
            return (Criteria) this;
        }

        public Criteria andPClicklikeMemberidGreaterThan(String value) {
            addCriterion("p_clicklike_memberid >", value, "pClicklikeMemberid");
            return (Criteria) this;
        }

        public Criteria andPClicklikeMemberidGreaterThanOrEqualTo(String value) {
            addCriterion("p_clicklike_memberid >=", value, "pClicklikeMemberid");
            return (Criteria) this;
        }

        public Criteria andPClicklikeMemberidLessThan(String value) {
            addCriterion("p_clicklike_memberid <", value, "pClicklikeMemberid");
            return (Criteria) this;
        }

        public Criteria andPClicklikeMemberidLessThanOrEqualTo(String value) {
            addCriterion("p_clicklike_memberid <=", value, "pClicklikeMemberid");
            return (Criteria) this;
        }

        public Criteria andPClicklikeMemberidLike(String value) {
            addCriterion("p_clicklike_memberid like", value, "pClicklikeMemberid");
            return (Criteria) this;
        }

        public Criteria andPClicklikeMemberidNotLike(String value) {
            addCriterion("p_clicklike_memberid not like", value, "pClicklikeMemberid");
            return (Criteria) this;
        }

        public Criteria andPClicklikeMemberidIn(List<String> values) {
            addCriterion("p_clicklike_memberid in", values, "pClicklikeMemberid");
            return (Criteria) this;
        }

        public Criteria andPClicklikeMemberidNotIn(List<String> values) {
            addCriterion("p_clicklike_memberid not in", values, "pClicklikeMemberid");
            return (Criteria) this;
        }

        public Criteria andPClicklikeMemberidBetween(String value1, String value2) {
            addCriterion("p_clicklike_memberid between", value1, value2, "pClicklikeMemberid");
            return (Criteria) this;
        }

        public Criteria andPClicklikeMemberidNotBetween(String value1, String value2) {
            addCriterion("p_clicklike_memberid not between", value1, value2, "pClicklikeMemberid");
            return (Criteria) this;
        }

        public Criteria andPTypeIdIsNull() {
            addCriterion("p_type_id is null");
            return (Criteria) this;
        }

        public Criteria andPTypeIdIsNotNull() {
            addCriterion("p_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andPTypeIdEqualTo(Integer value) {
            addCriterion("p_type_id =", value, "pTypeId");
            return (Criteria) this;
        }

        public Criteria andPTypeIdNotEqualTo(Integer value) {
            addCriterion("p_type_id <>", value, "pTypeId");
            return (Criteria) this;
        }

        public Criteria andPTypeIdGreaterThan(Integer value) {
            addCriterion("p_type_id >", value, "pTypeId");
            return (Criteria) this;
        }

        public Criteria andPTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_type_id >=", value, "pTypeId");
            return (Criteria) this;
        }

        public Criteria andPTypeIdLessThan(Integer value) {
            addCriterion("p_type_id <", value, "pTypeId");
            return (Criteria) this;
        }

        public Criteria andPTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("p_type_id <=", value, "pTypeId");
            return (Criteria) this;
        }

        public Criteria andPTypeIdIn(List<Integer> values) {
            addCriterion("p_type_id in", values, "pTypeId");
            return (Criteria) this;
        }

        public Criteria andPTypeIdNotIn(List<Integer> values) {
            addCriterion("p_type_id not in", values, "pTypeId");
            return (Criteria) this;
        }

        public Criteria andPTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("p_type_id between", value1, value2, "pTypeId");
            return (Criteria) this;
        }

        public Criteria andPTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("p_type_id not between", value1, value2, "pTypeId");
            return (Criteria) this;
        }

        public Criteria andPMessageIdIsNull() {
            addCriterion("p_message_id is null");
            return (Criteria) this;
        }

        public Criteria andPMessageIdIsNotNull() {
            addCriterion("p_message_id is not null");
            return (Criteria) this;
        }

        public Criteria andPMessageIdEqualTo(Integer value) {
            addCriterion("p_message_id =", value, "pMessageId");
            return (Criteria) this;
        }

        public Criteria andPMessageIdNotEqualTo(Integer value) {
            addCriterion("p_message_id <>", value, "pMessageId");
            return (Criteria) this;
        }

        public Criteria andPMessageIdGreaterThan(Integer value) {
            addCriterion("p_message_id >", value, "pMessageId");
            return (Criteria) this;
        }

        public Criteria andPMessageIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_message_id >=", value, "pMessageId");
            return (Criteria) this;
        }

        public Criteria andPMessageIdLessThan(Integer value) {
            addCriterion("p_message_id <", value, "pMessageId");
            return (Criteria) this;
        }

        public Criteria andPMessageIdLessThanOrEqualTo(Integer value) {
            addCriterion("p_message_id <=", value, "pMessageId");
            return (Criteria) this;
        }

        public Criteria andPMessageIdIn(List<Integer> values) {
            addCriterion("p_message_id in", values, "pMessageId");
            return (Criteria) this;
        }

        public Criteria andPMessageIdNotIn(List<Integer> values) {
            addCriterion("p_message_id not in", values, "pMessageId");
            return (Criteria) this;
        }

        public Criteria andPMessageIdBetween(Integer value1, Integer value2) {
            addCriterion("p_message_id between", value1, value2, "pMessageId");
            return (Criteria) this;
        }

        public Criteria andPMessageIdNotBetween(Integer value1, Integer value2) {
            addCriterion("p_message_id not between", value1, value2, "pMessageId");
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