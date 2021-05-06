package jiezhang.service;

import jiezhang.constant.BaseConstants;
import jiezhang.entity.BaseEntity;
import jiezhang.entity.DataTablePage;
import jiezhang.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Map;

/**
 * 抽象公共服务
 *
 * @author jiezhang
 * @date 2016/2/14
 */
public abstract class AbstractService<T extends BaseEntity, D extends BaseMapper<T, Exception>> implements BaseService<T, Exception> {
    @Autowired
    protected D mapper;

    @Autowired
    @Qualifier("snowflakeSequenceImpl")
    protected SequenceService sequenceService;


    public D getMapper() {
        return mapper;
    }

    public void setMapper(D mapper) {
        this.mapper = mapper;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int createEntity(T entity) throws Exception {
        long id = sequenceService.getSequence();
        entity.putIdField(String.valueOf(id));
        return mapper.insertEntity(entity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int removeEntity(T entity) throws Exception {
        Object object = entity.gainKeyValue();
        if (object == null) {
            throw new Exception("没有ID");
        }
        return mapper.deleteById(entity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int modifyEntity(T entity) throws Exception {
        return mapper.updateEntityNotNulById(entity);
    }

    @Override
    public T findEntity(T entity) throws Exception {
        return mapper.selectEntity(entity.toMap());
    }

    @Override
    public DataTablePage queryPage(Map parameters, DataTablePage page) throws Exception {
        //将自带的和传入的替代掉,
        if (parameters != null) {
            page.getParams().putAll(parameters);
        }
        List<T> list = mapper.queryDataTablePage(page);
        page.setAaData(list);
        return page;
    }

    @Override
    public int disable(T entity) throws Exception {
        entity.setState(BaseConstants.DISABLE);
        return modifyEntity(entity);
    }

    @Override
    public int enable(T entity) throws Exception {
        entity.setState(BaseConstants.ENABLE);
        return modifyEntity(entity);
    }
}
