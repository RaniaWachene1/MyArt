/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entite;

/**
 *
 * @author Acer
 */
public class Role {
    private int id_role;
    private String desc_role;  

    public Role() {
    }
//*****************************//

    public Role(int id_role) {
        this.id_role = id_role;
    }
    
    public Role(int id_role, String desc_role) {
        this.id_role = id_role;
        this.desc_role = desc_role;
    }
//*****************************//
    public void setId_role(int id_role) {
        this.id_role = id_role;
    }

    public void setDesc_role(String desc_role) {
        this.desc_role = desc_role;
    }
//***************************//
    public int getId_role() {
        return id_role;
    }

    public String getDesc_role() {
        return desc_role;
    }
//************************//
    @Override
    public String toString() {
        return "Role{" + "id_role=" + id_role + ", desc_role=" + desc_role + '}';
    }
   
    
   
    
    
}
