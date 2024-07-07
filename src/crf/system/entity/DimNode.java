package crf.system.entity;

public class DimNode {
	private String node_id;                           //数据库字段类型:NUMBER      ----字段长度:10    ----是否可为空:false ----字段默认值:         
    private String tree_id;                           //数据库字段类型:VARCHAR2    ----字段长度:10    ----是否可为空:true ----字段默认值:         
    private String node_no;                           //数据库字段类型:VARCHAR2    ----字段长度:20    ----是否可为空:true ----字段默认值:         
    private String node_name;                         //数据库字段类型:VARCHAR2    ----字段长度:40    ----是否可为空:true ----字段默认值:         
    private String node_level;                        //数据库字段类型:NUMBER      ----字段长度:3     ----是否可为空:true ----字段默认值:      1
 
    private String parent_id;                         //数据库字段类型:NUMBER      ----字段长度:10    ----是否可为空:true ----字段默认值:      0
 
    private String child_num;                         //数据库字段类型:NUMBER      ----字段长度:5     ----是否可为空:true ----字段默认值:      0
 
    private String seqstr;                            //数据库字段类型:VARCHAR2    ----字段长度:50    ----是否可为空:true ----字段默认值:         
    private String node_prop;                         //数据库字段类型:NUMBER      ----字段长度:3     ----是否可为空:true ----字段默认值:         
    private String node_icon;                         //数据库字段类型:VARCHAR2    ----字段长度:50    ----是否可为空:true ----字段默认值:         
    private String node_face;                         //数据库字段类型:VARCHAR2    ----字段长度:50    ----是否可为空:true ----字段默认值:         
    private String state;                             //数据库字段类型:NUMBER      ----字段长度:3     ----是否可为空:true ----字段默认值:      1
 
    /** 
    * @return the node_id 
    */ 
    public String getNode_id() { 
    	return node_id; 
    } 
    
    /** 
    * @param node_id the node_id to set 
    */ 
    public void setNode_id(String node_id) { 
    	this.node_id = node_id; 
    } 
 
    
    /** 
    * @return the tree_id 
    */ 
    public String getTree_id() { 
    	return tree_id; 
    } 
    
    /** 
    * @param tree_id the tree_id to set 
    */ 
    public void setTree_id(String tree_id) { 
    	this.tree_id = tree_id; 
    } 
 
    
    /** 
    * @return the node_no 
    */ 
    public String getNode_no() { 
    	return node_no; 
    } 
    
    /** 
    * @param node_no the node_no to set 
    */ 
    public void setNode_no(String node_no) { 
    	this.node_no = node_no; 
    } 
 
    
    /** 
    * @return the node_name 
    */ 
    public String getNode_name() { 
    	return node_name; 
    } 
    
    /** 
    * @param node_name the node_name to set 
    */ 
    public void setNode_name(String node_name) { 
    	this.node_name = node_name; 
    } 
 
    
    /** 
    * @return the node_level 
    */ 
    public String getNode_level() { 
    	return node_level; 
    } 
    
    /** 
    * @param node_level the node_level to set 
    */ 
    public void setNode_level(String node_level) { 
    	this.node_level = node_level; 
    } 
 
    
    /** 
    * @return the parent_id 
    */ 
    public String getParent_id() { 
    	return parent_id; 
    } 
    
    /** 
    * @param parent_id the parent_id to set 
    */ 
    public void setParent_id(String parent_id) { 
    	this.parent_id = parent_id; 
    } 
 
    
    /** 
    * @return the child_num 
    */ 
    public String getChild_num() { 
    	return child_num; 
    } 
    
    /** 
    * @param child_num the child_num to set 
    */ 
    public void setChild_num(String child_num) { 
    	this.child_num = child_num; 
    } 
 
    
    /** 
    * @return the seqstr 
    */ 
    public String getSeqstr() { 
    	return seqstr; 
    } 
    
    /** 
    * @param seqstr the seqstr to set 
    */ 
    public void setSeqstr(String seqstr) { 
    	this.seqstr = seqstr; 
    } 
 
    
    /** 
    * @return the node_prop 
    */ 
    public String getNode_prop() { 
    	return node_prop; 
    } 
    
    /** 
    * @param node_prop the node_prop to set 
    */ 
    public void setNode_prop(String node_prop) { 
    	this.node_prop = node_prop; 
    } 
 
    
    /** 
    * @return the node_icon 
    */ 
    public String getNode_icon() { 
    	return node_icon; 
    } 
    
    /** 
    * @param node_icon the node_icon to set 
    */ 
    public void setNode_icon(String node_icon) { 
    	this.node_icon = node_icon; 
    } 
 
    
    /** 
    * @return the node_face 
    */ 
    public String getNode_face() { 
    	return node_face; 
    } 
    
    /** 
    * @param node_face the node_face to set 
    */ 
    public void setNode_face(String node_face) { 
    	this.node_face = node_face; 
    } 
 
    
    /** 
    * @return the state 
    */ 
    public String getState() { 
    	return state; 
    } 
    
    /** 
    * @param state the state to set 
    */ 
    public void setState(String state) { 
    	this.state = state; 
    } 
}
