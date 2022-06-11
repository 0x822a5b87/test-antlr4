void stat() {
	switch{
		case ID : 
			assign();
			break;
		case IF:
			ifstat();
			break;
		case WHILE:
			whilestat();
			break;
		default:
			// nothing to do, throw parse exception
	}
}
