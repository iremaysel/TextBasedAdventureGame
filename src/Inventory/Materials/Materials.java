package Inventory.Materials;

import Inventory.Inventory;

public class Materials extends Inventory {

    public Materials(String name, boolean status) {
        super(name, status);
    }

    public static Materials[] createMaterial(){
        Materials food = new Food();
        Materials water = new Water();
        Materials firewood = new Firewood();

        Materials[] materials = {food, water, firewood};

        return materials;
    }

    public static void printMaterials(Inventory[] materials){
        System.out.println("    Materials      |  Your spoils");
        for (Inventory m : materials) {
            int status;
            if (m.getStatus()==false)
                status = 0;
            else {
                status = 1;
            }
            System.out.print("     * " + m.getName() + "  \t");
            System.out.print("       " + status + "  \t\n");
        }
    }

    public static Inventory choiceMaterial(String materialName){
        Inventory[] materials = createMaterial();

        Inventory temp = null;

        for (Inventory m: materials) {
            if(m.getName().equals(materialName.toUpperCase())){
                temp = m;
                return m;
            }
        }
        return temp;
    }
}
