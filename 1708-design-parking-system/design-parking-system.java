 class ParkingSystem {

    int big,medium,small;
    public ParkingSystem(int b, int m, int s) {
        big = b; 
        medium = m;
        small = s;
    }
    
    public boolean addCar(int carType) {
        if(carType == 1 && big >0 ) {
            big--;
            return true;
        }else if(carType == 2 && medium > 0){
            medium--;
            return true;
        }else if(carType == 3 && small > 0){
            small--;
            return true;
        }

        return false;
    }
}

