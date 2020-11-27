package ecom;

import org.junit.Test;

import static org.junit.Assert.*;

public class EcomTest {
    @Test
    public void testBuyMachines() {
        EcommerceFacade ecommerceFacade = new EcommerceFacade();
        ecommerceFacade.addMachine("PRODIGIO", 1, 150);
        ecommerceFacade.addMachine("PIXIE", 1, 350);
        ecommerceFacade.addMachine("CITIZ", 1, 200);
        assertEquals("Machine\n\tName: CITIZ\tQuantity: 1\tPrice: 200\n\tName: PIXIE\tQuantity: 1\tPrice: 350\n\tName: PRODIGIO\tQuantity: 1\tPrice: 150\n", ecommerceFacade.cartContent());
    }
   @Test
    public void testGroupMachinesWithTheSameName() {
        EcommerceFacade ecommerceFacade = new EcommerceFacade();
        ecommerceFacade.addMachine("PRODIGIO", 1, 150);
        ecommerceFacade.addMachine("PIXIE", 1, 350);
        ecommerceFacade.addMachine("CITIZ", 1, 200);
        ecommerceFacade.addMachine("PIXIE", 1, 350);
        assertEquals("Machine\n\tName: CITIZ\tQuantity: 1\tPrice: 200\n\tName: PIXIE\tQuantity: 2\tPrice: 700\n\tName: PRODIGIO\tQuantity: 1\tPrice: 150\n", ecommerceFacade.cartContent());
    }
    @Test
    public void testRomoveMachine() {
        EcommerceFacade ecommerceFacade = new EcommerceFacade();
        ecommerceFacade.addMachine("PRODIGIO", 1, 150);
        ecommerceFacade.addMachine("PIXIE", 1, 350);
        ecommerceFacade.addMachine("CITIZ", 1, 200);
        ecommerceFacade.addMachine("PIXIE", 1, 350);
        ecommerceFacade.removeMachine("PIXIE", 1);
        assertEquals("Machine\n\tName: CITIZ\tQuantity: 1\tPrice: 200\n\tName: PIXIE\tQuantity: 1\tPrice: 350\n\tName: PRODIGIO\tQuantity: 1\tPrice: 150\n", ecommerceFacade.cartContent());
    }
   @Test
    public void testBuyCapsules() {
        EcommerceFacade ecommerceFacade = new EcommerceFacade();
        ecommerceFacade.addCapsule("ROMA", 20, 3);
        ecommerceFacade.addCapsule("RISTRETTO", 15, 4);
        ecommerceFacade.addCapsule("KAZAAR", 10, 5);
        assertEquals("Capsule\n\tName: KAZAAR\tQuantity: 10\tPrice: 50\n\tName: RISTRETTO\tQuantity: 15\tPrice: 60\n\tName: ROMA\tQuantity: 20\tPrice: 60\n", ecommerceFacade.cartContent());
    }
    @Test
    public void testGroupCapsulesWithTheSameName() {
        EcommerceFacade ecommerceFacade = new EcommerceFacade();
        ecommerceFacade.addCapsule("ROMA", 20, 3);
        ecommerceFacade.addCapsule("RISTRETTO", 15, 4);
        ecommerceFacade.addCapsule("KAZAAR", 10, 5);
        ecommerceFacade.addCapsule("ROMA", 10, 3);
        assertEquals("Capsule\n\tName: KAZAAR\tQuantity: 10\tPrice: 50\n\tName: RISTRETTO\tQuantity: 15\tPrice: 60\n\tName: ROMA\tQuantity: 30\tPrice: 90\n", ecommerceFacade.cartContent());
    }
    @Test
    public void testRemoveCapsule() {
        EcommerceFacade ecommerceFacade = new EcommerceFacade();
        ecommerceFacade.addCapsule("ROMA", 20, 3);
        ecommerceFacade.addCapsule("RISTRETTO", 15, 4);
        ecommerceFacade.addCapsule("KAZAAR", 10, 5);
        ecommerceFacade.addCapsule("ROMA", 10, 3);
        ecommerceFacade.removeCapsule("ROMA", 15);
        assertEquals("Capsule\n\tName: KAZAAR\tQuantity: 10\tPrice: 50\n\tName: RISTRETTO\tQuantity: 15\tPrice: 60\n\tName: ROMA\tQuantity: 15\tPrice: 45\n", ecommerceFacade.cartContent());
    }
    @Test
    public void testBuyMachinesAndCapsules() {
        EcommerceFacade ecommerceFacade = new EcommerceFacade();
        ecommerceFacade.addMachine("PRODIGIO", 1, 150);
        ecommerceFacade.addMachine("PIXIE", 1, 350);
        ecommerceFacade.addMachine("CITIZ", 1, 200);
        ecommerceFacade.addMachine("PIXIE", 1, 350);
        ecommerceFacade.addCapsule("ROMA", 20, 3);
        ecommerceFacade.addCapsule("RISTRETTO", 15, 4);
        ecommerceFacade.addCapsule("KAZAAR", 10, 5);
        ecommerceFacade.addCapsule("ROMA", 10, 3);
        assertEquals("Capsule\n\tName: KAZAAR\tQuantity: 10\tPrice: 50\n\tName: RISTRETTO\tQuantity: 15\tPrice: 60\n\tName: ROMA\tQuantity: 30\tPrice: 90\nMachine\n\tName: CITIZ\tQuantity: 1\tPrice: 200\n\tName: PIXIE\tQuantity: 2\tPrice: 700\n\tName: PRODIGIO\tQuantity: 1\tPrice: 150\n", ecommerceFacade.cartContent());
    }
    @Test
    public void testMachinesAndCapsulesSummary() {
        EcommerceFacade ecommerceFacade = new EcommerceFacade();
        ecommerceFacade.addMachine("PRODIGIO", 1, 150);
        ecommerceFacade.addMachine("PIXIE", 1, 350);
        ecommerceFacade.addMachine("CITIZ", 1, 200);
        ecommerceFacade.addMachine("PIXIE", 1, 350);

        ecommerceFacade.addCapsule("ROMA", 20, 3);
        ecommerceFacade.addCapsule("RISTRETTO", 15, 4);
        ecommerceFacade.addCapsule("KAZAAR", 10, 5);
        ecommerceFacade.addCapsule("ROMA", 10, 3);
        assertEquals("Capsule\n\tQuantity: 55\tPrice: 200\nMachine\n\tQuantity: 4\tPrice: 1050\nTotal Price: 1250\n", ecommerceFacade.summary());
    }
   @Test
    public void testCantOrderAnEmptyCart() {
        EcommerceFacade ecommerceFacade = new EcommerceFacade();
        ecommerceFacade.order();
        assertTrue(ecommerceFacade.hasErrors());
        assertEquals("Empty Cart", ecommerceFacade.errors());
    }
    @Test
    public void testPackagingRuleCapsules() {
        EcommerceFacade ecommerceFacade = new EcommerceFacade();
        ecommerceFacade.addCapsule("ROMA", 7, 3);
        ecommerceFacade.addCapsule("RISTRETTO", 15, 4);
        ecommerceFacade.addCapsule("KAZAAR", 10, 5);
        ecommerceFacade.order();
        assertTrue(ecommerceFacade.hasErrors());
        assertEquals("ROMA: Invalid Quantity, must be a multiple of 5", ecommerceFacade.errors());
    }
    @Test
    public void testVoucherCodeFailIfNotNumeric() {
        EcommerceFacade ecommerceFacade = new EcommerceFacade();
        ecommerceFacade.voucher("vouchercode");
        ecommerceFacade.addMachine("PIXIE", 1, 350);
        ecommerceFacade.order();
        assertTrue(ecommerceFacade.hasErrors());
        assertEquals("Invalid voucher code", ecommerceFacade.errors());
    }
    @Test
    public void testVoucherCodeSucessIfNumeric() {
        EcommerceFacade ecommerceFacade = new EcommerceFacade();
        ecommerceFacade.voucher("12345");
        ecommerceFacade.addMachine("PIXIE", 1, 350);
        ecommerceFacade.order();
        assertFalse(ecommerceFacade.hasErrors());
    }
    @Test
    public void testVoucherCodeRequireMachinePurchase() {
        EcommerceFacade ecommerceFacade = new EcommerceFacade();
        ecommerceFacade.voucher("12345");
        ecommerceFacade.addCapsule("ROMA", 20, 3);
        ecommerceFacade.addCapsule("RISTRETTO", 15, 4);
        ecommerceFacade.addCapsule("KAZAAR", 10, 5);
        ecommerceFacade.order();
        assertTrue(ecommerceFacade.hasErrors());
        assertEquals("Voucher requires machine purchase", ecommerceFacade.errors());
    }

}
