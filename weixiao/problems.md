### 问题与解决

- ##### LocalDateTime格式转换

  - 解决：在字段属性上加上
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+08:00")

- ##### BeanUtils.copyProperties在拷贝属性时忽略空值
  - 解决：

    第三个参数传要忽略的字段，通过

    ```java
    public static String[] getNullPropertyNames (Object source) {
            final BeanWrapper src = new BeanWrapperImpl(source);
            java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();
    
            Set<String> emptyNames = new HashSet<String>();
            for(java.beans.PropertyDescriptor pd : pds) {
                Object srcValue = src.getPropertyValue(pd.getName());
                if (srcValue == null) emptyNames.add(pd.getName());
            }
            String[] result = new String[emptyNames.size()];
            return emptyNames.toArray(result);
        }
    ```

    传入model，获取model中为空的字段，返回值作为第三个参数传入。

- ##### @DynamicInsert@DynamicUpdate使用后，save返回值是没有那些空字段的

  - 解决：实际上在数据库中插入时那些字段已经是默认值插入了，所过实在要返回，可以查询一次再返回。
  - 更新：使用 EntityManager entityManager的.refresh(entity)方法，可以更新缓存中的数据，但是需要在方法上加入@Transactional注解。
  
- ##### admin与student是两个模块，service不共用，但是在admin里却要对student经行管理

  - 解决：使用springcloud的eureka与feign组件，将admin与student注册到eureka中，admin通过feign调用student接口。

- ##### 在student中也需要jwt验证，但是在feign调用时确没有token传过去。

  - 在调用feign的方法中使用@RequestHeader，将token信息自动注入到参数中，但是需要在student表中也要有admin管理员的账号信息，否则验证不通过。
  
- ##### jpa做数据查询时，当查询的数据列表主键有相同的时候，那么之后出第一条外，其他相同的主键值会全部为第一次出现时的值。

  - 解决：mysql查询语句里，增加自定义主键列，保证主键唯一，在实体里增加一列，标为主键(例：SELECT @rownum:=@rownum+1 AS rownum, table_name.* FROM (SELECT @rownum:=0) r, table_name ;)，但是在jpa中，由于不识别 : 字符，需要在 : 前用 \\\\ 转义。
  
- ##### Feign调用报错The bean 'XXX.FeignClientSpecification', defined in null, could not be registered....的解决办法

  - 一种方式在application.yml中配置：

    - ```java
      spring:
        main:
          allow-bean-definition-overriding: true
      ```

  - 第二种办法：
    - 可以在@FeignClient注解上添加contextId解决该问题，如：@FeignClient(name="common-service", contextId = "exp")