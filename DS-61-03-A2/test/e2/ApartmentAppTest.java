package e2;


import e1.School;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ApartmentAppTest {

        private ApartmentApp app;

        @BeforeEach
        void setUp() {
                app = new ApartmentApp();
                app.insertApartment("Calle Rosalia de castro 2",100,100,3,1,4);
                app.insertApartment("Calle Rosalia de castro 3",200,99,101,2,5,7);
                app.insertApartment("Calle Rosalia de castro 4",5,99,1,5,1,7,100,5,3);
                app.insertApartment("Calle Rosalia de castro 4",5,99,1,5,7,1,5,3,100);
        }

        @Test
        void InvalidAdvertisement(){

        }

        @Test
        void TestInsertion(){


        }

        @Test
        void TestOrder_basePrice(){


        }

        @Test
        void TestOrder_totalPrice(){


        }

        @Test
        void TestOrder_size(){


        }

        @Test
        void TestOrder_beds(){


        }

        @Test
        void TestOrder_NaturalOrder(){


        }

}
