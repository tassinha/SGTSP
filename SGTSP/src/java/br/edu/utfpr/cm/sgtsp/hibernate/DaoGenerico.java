package br.edu.utfpr.cm.sgtsp.hibernate;

import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

/**
 *
 */
public abstract class DaoGenerico<T> {

    Object object;
     Session sessao;
     Criteria criteria;
     Class objectClass;

    public Session getSessao() {
        return sessao;
    }

    public DaoGenerico() {
        begin();
    }

    public DaoGenerico(Object object) {
        this.object = object;
    }

    public void setaObjeto(Object object) {
        this.object = object;
    }

    private Class getObjectClass() {
        objectClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return objectClass;
    }

    public void commit() {
        this.sessao.beginTransaction().commit();
        this.sessao.flush();
       // this.sessao.close();
    }
    public void commit(boolean fecharSessao) {
        this.sessao.beginTransaction().commit();
        this.sessao.flush();
        if(fecharSessao) {
           this.sessao.close();
            System.out.println("fechou sessao ================================================================================");
        }
    }

    private void begin() {
        if(sessao==null){
        sessao = Mapeador.getSessao();
        criteria = sessao.createCriteria(getObjectClass());
        sessao.beginTransaction().begin();
                    }
    }
    public void fechaSessao(){
        if(sessao==null){
            sessao.close();
        }
    }

    public List<T> get() {
        criteria.addOrder(Order.asc("id"));
        return listResult(criteria);
    }
    public List<T> get(boolean fechaSessao) {
        criteria.addOrder(Order.asc("id"));
        return listResult(criteria);
    }

    public List<T> getNFEOrderDataEnvio() {
        criteria.addOrder(Order.desc("dataEnvio"));
        return listResult(criteria);
    }

    public T get(Integer id) {
        criteria.add(Expression.eq("id", id));
        criteria.addOrder(Order.asc("id"));
        return uniqueResult(criteria);
//        return uniqueResult(criteria.add(Expression.eq("id", id)));
    }
    public T get(Integer id, boolean fecharSessao) {
        criteria.add(Expression.eq("id", id));
        criteria.addOrder(Order.asc("id"));
        return uniqueResult(criteria,true);
//        return uniqueResult(criteria.add(Expression.eq("id", id)));
    }
    public T get(Long id) {
        criteria.add(Expression.eq("id", id));
        criteria.addOrder(Order.asc("id"));
        return uniqueResult(criteria);
//        return uniqueResult(criteria.add(Expression.eq("id", id)));
    }
    public T get(Long id,boolean fecharSessao) {
        criteria.add(Expression.eq("id", id));
        criteria.addOrder(Order.asc("id"));
        return uniqueResult(criteria,fecharSessao);
    }

    public T getUltimaSequencia() {
        return uniqueResult(criteria.setProjection(Projections.max("id")));

    }

    public Long getUltimaSequencia2() {
        Criteria a = criteria.setProjection(Projections.max("id"));
        return (Long) a.uniqueResult();

    }

    public List<T> get(Long... ids) {
        criteria.add(Expression.in("id", ids));
        criteria.addOrder(Order.asc("id"));

        return listResult(criteria);
    }

    public T uniqueResult(Criteria cri) {
        T ret = (T) cri.uniqueResult();
        commit();
        return ret;

    }
    public T uniqueResult(Criteria cri,boolean fecharSessao) {
        T ret = (T) cri.uniqueResult();
        commit(fecharSessao);
        return ret;

    }

    public List<T> listResult(Criteria cri) {
        List ret = cri.list();
        commit();
        return ret;
    }
    public List<T> listResult(Criteria cri,boolean fechaSessao) {
        List ret = cri.list();
        commit(fechaSessao);
        return ret;
    }
    public Boolean valida;

    public void update() {

        begin();
        this.sessao.update(object);
        commit();

    }

    public void delete() {
        begin();
        this.sessao.delete(object);
        commit();
    }

    public void persist() {
        begin();
        this.sessao.saveOrUpdate(object);
        commit();
    }
    public void persist(boolean fecharSessao) {
        begin();
        this.sessao.saveOrUpdate(object);
        commit(fecharSessao);
    }

    public List<T> getPorString(String where) {
        String[] merda = where.split("=");
        this.criteria.add(Expression.eq(merda[0], merda[1]));
        criteria.addOrder(Order.asc("id"));


        return listResult(criteria);
    }

    public List<T> getPorComandoSql(String where) {
        this.criteria.add(Expression.sql(where));
        criteria.addOrder(Order.asc("id"));
        return listResult(criteria);
    }

    public List<T> getEntreDatas(Date data1, Date data2) {
        this.criteria.add(Expression.between("dataCriacao", data1, data2));
        criteria.addOrder(Order.asc("id"));
        return listResult(criteria);
    }

    public List<T> getEntreDatas2(Date data1, Date data2) {
        this.criteria.add(Expression.between("dataPreDatado", data1, data2));
        criteria.addOrder(Order.asc("id"));
        return listResult(criteria);

    }

    public List<T> getCampoTabelaIgualParametro(String campo, Object valor) {
        this.criteria.add(Expression.eq(campo, valor));
        return listResult(criteria);
    }
}
