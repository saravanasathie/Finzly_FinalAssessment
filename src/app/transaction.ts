import { CustomerData } from "./customer-data";

export class Transaction {
    tId!:number;
    transactionMethod !:string;
	unitConsumption!:number;
	status!:string;
	totalAmount !:number;
	discount !:number;
	startDate !:Date;
	endDate !:Date;
	rate!:number;
	customer!: CustomerData;
	referenceNumber! : string;
}
