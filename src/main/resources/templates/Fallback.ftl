
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class ${tableNameFormat}ServiceFallback implements FallbackFactory<${tableNameFormat}Service>{

    @Override
    public ${tableNameFormat}Service create(Throwable throwable) {
        return new ${tableNameFormat}Service() {

            @Override
            public String insert(${tableNameFormat}DTO record) throws BizException {
                throw new BizException("9999", "系统繁忙,请稍候重试!");
            }

            @Override
            public String delete(Integer ${tableNameFormatOnCase}Id) throws BizException {
                throw new BizException("9999", "系统繁忙,请稍候重试!");
            }

            @Override
            public String update(${tableNameFormat}DTO record) throws BizException {
                throw new BizException("9999", "系统繁忙,请稍候重试!");
            }

            @Override
            public String queryList(${tableNameFormat}Query query) throws BizException {
                throw new BizException("9999", "系统繁忙,请稍候重试!");
            }
            @Override
            public String querySingle(Integer ${tableNameFormatOnCase}Id) throws BizException {
                throw new BizException("9999", "系统繁忙,请稍候重试!");
            }

        };
    }
}

