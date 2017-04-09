package br.com.pirlamps.farmtracker.foundation.joat;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;

public class JoatObject extends Object implements Serializable {


    private Integer headerType;
    private String headerTitle;
    private int bindingRes;
    private Integer bindingObjectID;
    private Object bindingObject;

    public JoatObject() {
    }

    /**
     *
     *
     * @param bindingRes É o resource do layout que ira ser inflado em sua row.<br/> <b>EX: R.layout.row_simple</b>
     * @param bindingObjectID É o ID gerado pelo DataBinging quando o XML é construido, ele se encontra no Package <i>BR.nome_da_sua_variavel_no_XML</i>.<br/> <b>EX: BR.simpleObject</b>
     * @param bindingObject É o Objeto que será atribuido ao seu XML. <br/> <b>simpleObject</b>
     * @param headerTitle É o Título do seu Header, um grupo de objetos com o mesmo Header irão estar agrupados sobre o mesmo. Este atributo poderá ser nulo caso não haja a necessidade de um Header. <br/> <b>EX: "Titulo Simples"</b>
     */
    public JoatObject(@NotNull Integer bindingRes, @NotNull Integer bindingObjectID, @NotNull Object bindingObject, @Nullable String headerTitle) {
        this.bindingRes = bindingRes;
        this.headerTitle = headerTitle;
        this.headerType = this.headerTitle == null ? 0 : this.headerTitle.hashCode();
        this.bindingObjectID = bindingObjectID;
        this.bindingObject = bindingObject;
    }

    public Integer getHeaderType() {
        return headerType;
    }

    public void setHeaderType(Integer headerType) {
        this.headerType = headerType;
    }

    public String getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

    public int getBindingRes() {
        return bindingRes;
    }

    public void setBindingRes(int bindingRes) {
        this.bindingRes = bindingRes;
    }

    public Integer getBindingObjectID() {
        return bindingObjectID;
    }

    public void setBindingObjectID(Integer bindingObjectID) {
        this.bindingObjectID = bindingObjectID;
    }

    public Object getBindingObject() {
        return bindingObject;
    }

    public void setBindingObject(Object bindingObject) {
        this.bindingObject = bindingObject;
    }
}