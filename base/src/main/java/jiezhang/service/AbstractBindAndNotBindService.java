package jiezhang.service;


import jiezhang.entity.BaseEntity;
import jiezhang.entity.DataTablePage;
import jiezhang.mapper.BaseBindAndNotBindMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.*;

/**
 * 中间表绑定与未绑定抽象类
 *
 * @param <F> 多对象
 * @param <T> 一对象
 * @param <D> mapper
 * @param <E> 异常
 * @author jiezhang
 * @date 2018/02/09
 */
public abstract class AbstractBindAndNotBindService<M extends BaseEntity, T extends BaseEntity, F extends BaseEntity, D extends BaseBindAndNotBindMapper<F, T, E>, E extends Exception> implements BaseBindAndNotBindService<M, T, F, E> {
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
    public DataTablePage queryBindDataTablePage(Map parameters, DataTablePage<F> page) throws Exception {
        page.setParams(parameters);
        List<F> list = mapper.queryBindDataTablePage(page);
        page.setAaData(list);
        return page;
    }

    @Override
    public DataTablePage queryNotBindDataTablePage(Map parameters, DataTablePage<F> page) throws Exception {
        page.setParams(parameters);
        List<F> list = mapper.queryNotBindDataTablePage(page);
        page.setAaData(list);
        return page;
    }

    @Override
    public int bind(List<T> list) throws Exception {
        List<T> insertList = new ArrayList(list.size());
        //防止出现一毫秒内重号
        Set<String> set = new HashSet<String>();
        while (true) {
            if (set.size() == list.size()) {
                break;
            } else {
                set.add(String.valueOf(sequenceService.getSequence()));
            }
        }
        List<String> seqList = new LinkedList();
        seqList.addAll(set);
        for (int i = 0; i < list.size(); i++) {
            T entity = list.get(i);
            entity.putIdField(seqList.get(i));
        }
//        for (T entity : list) {
//            entity.putIdField(String.valueOf(sequenceService.getSequence()));
//        }
        return mapper.insertList(list);
    }

    @Override
    public int unbind(Map parameter) throws Exception {
        return mapper.removeList(parameter);
    }
}
