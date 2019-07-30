<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="">

    <resultMap id="BaseResultMap" type="${tableNameFormat}DTO">
        <#list baseResultMapVoList as baseResultMapVo >
        <id column="${baseResultMapVo.column}" property="${baseResultMapVo.property}" jdbcType="${baseResultMapVo.jdbcType}"/>
        </#list>
    </resultMap>

    <sql id="Base_Column_List">
        <#list baseResultMapVoList as baseResultMapVo >
        <#if baseResultMapVo_has_next>${tableShortName}.${baseResultMapVo.column} AS ${baseResultMapVo.property},<#else>${tableShortName}.${baseResultMapVo.column} AS ${baseResultMapVo.property}</#if>
        </#list>
    </sql>

    <insert id="insert" parameterType="${tableNameFormat}DTO">
        INSERT INTO ${tableName}
        ( <#list baseColumnList as baseColumn >
        <#if baseColumn_has_next>${baseColumn},<#else>${baseColumn}</#if></#list>
        )
        VALUES
        (
        <#list baseResultMapVoList as baseResultMapVo >
        <#if baseResultMapVo_has_next><#noparse>#{</#noparse>${baseResultMapVo.property}},<#else><#noparse>#{</#noparse>${baseResultMapVo.property}}</#if>
        </#list>
        )
    </insert>


    <delete id="deleteById" parameterType="java.lang.Long">
        DELETE FROM ${tableName}
        where <#list uniqueIndexVOList as uniqueIndexVo ><#if uniqueIndexVo_has_next>${uniqueIndexVo.dataColumnName} =  <#noparse>#{</#noparse>${uniqueIndexVo.dataColumnNameFormat}} and <#else>${uniqueIndexVo.dataColumnName} =  <#noparse>#{</#noparse>${uniqueIndexVo.dataColumnNameFormat}}</#if></#list>
    </delete>

    <update id="update" parameterType="${tableNameFormat}DTO">
        update ${tableName}
        <set>
        <#list baseResultMapVoList as baseResultMapVo >
            <#if baseResultMapVo.jdbcType == "VARCHAR">
            <if test=" ${baseResultMapVo.property} != null and ${baseResultMapVo.property} !=''">
                ${baseResultMapVo.column} =<#noparse>#{</#noparse>${baseResultMapVo.property}},
            </if>
            <#else>
            <if test="${baseResultMapVo.property} != null">
                ${baseResultMapVo.column} = <#noparse>#{</#noparse>${baseResultMapVo.property}},
            </if>
            </#if>
        </#list>
        </set>
        where <#list uniqueIndexVOList as uniqueIndexVo ><#if uniqueIndexVo_has_next>${uniqueIndexVo.dataColumnName} =  <#noparse>#{</#noparse>${uniqueIndexVo.dataColumnNameFormat}} and <#else>${uniqueIndexVo.dataColumnName} =  <#noparse>#{</#noparse>${uniqueIndexVo.dataColumnNameFormat}}</#if></#list>
    </update>

    <select id="queryList" resultType="${tableNameFormat}DTO" parameterType="${tableNameFormat}Query">
        select <include refid="Base_Column_List"/> from ${tableName} ${tableShortName}
        <trim prefix="WHERE" prefixOverrides="AND">
        <#list baseResultMapVoList as baseResultMapVo >
            <#if baseResultMapVo.jdbcType == "VARCHAR">
            <if test="${baseResultMapVo.property} != null and ${baseResultMapVo.property} !=''">
                AND ${tableShortName}.${baseResultMapVo.column} =<#noparse>#{</#noparse>${baseResultMapVo.property}}
            </if>
            <#else>
            <if test="${baseResultMapVo.property} != null">
                AND ${tableShortName}.${baseResultMapVo.column} = <#noparse>#{</#noparse>${baseResultMapVo.property}}
            </if>
            </#if>
        </#list>
        </trim>
    </select>

    <select id="queryById" resultType="${tableNameFormat}DTO" parameterType="${tableNameFormat}Query">
        select <include refid="Base_Column_List"/> from ${tableName} ${tableShortName}
        where <#list uniqueIndexVOList as uniqueIndexVo ><#if uniqueIndexVo_has_next>${tableShortName}.${uniqueIndexVo.dataColumnName} =  <#noparse>#{</#noparse>${uniqueIndexVo.dataColumnNameFormat}} and <#else>${tableShortName}.${uniqueIndexVo.dataColumnName} =  <#noparse>#{</#noparse>${uniqueIndexVo.dataColumnNameFormat}}</#if></#list>
    </select>
</mapper>