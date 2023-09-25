export interface Bill {
    billId: number;
    customerName: string;
    customerId: number;
    unitConsumed: number;
    billStartDate: Date;
    billDueDate: Date;
    email: string;
    telephone: string;
    billStatus: string;
}
