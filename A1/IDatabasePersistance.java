public interface IDatabasePersistance {
	
    public static final boolean PERSIST_SUCCESS = true;
    public static final boolean PERSIST_FAILURE = false;
    
    public boolean commit(IDatabasePersistance db);
    public boolean rollback(IDatabasePersistance db);

}