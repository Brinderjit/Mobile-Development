package CourseManager;
import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;



public class CourseManager extends SQLiteOpenHelper {

    //database name and version
    private static final String DATABASE_NAME = "Course.db";
    private static final int DATABASE_VERSION = 1;
    //SQLite types
    private static final String BOOLEAN = "Boolean";
    private static final String BYTE = "Byte";
    private static final String SHORT = "Short";
    private static final String INTEGER = "Integer";
    private static final String LONG = "Long";
    private static final String FLOAT = "Float";
    private static final String DOUBLE = "Double";
    private static final String STRING = "String";
    //
    private String tableName; //table name
    private String tableCreatorString; //SQL statement to create the table
    //
    public CourseManager(Context context)
    {
        super(context, DATABASE_NAME , null, 1);

    }
    //
    //initialize table names and CREATE TABLE statement
    //called by activity to create a table in the database
    //The following arguments should be passed:
    // tableName - a String variable which holds the table name
    // tableCreatorString - a String variable which holds the CREATE Table statement

    public void dbInitialize(String tableName, String tableCreatorString)
    {
        this.tableName=tableName;
        this.tableCreatorString=tableCreatorString;

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //drop table
        //create the table
        db.execSQL(tableCreatorString);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //
        db.execSQL("DROP TABLE IF EXISTS " + tableName);
        onCreate(db);
    }

    //
    //This method is called by the activity to add a row in the table
    // The following arguments should be passed:
    //  fieldNames - a String array that holds the names of table fields
    //  fieldTypes - a String array that holds the Java types of table fields
    //  fieldValues - an Object array that holds the values to be stored in table fields
    //
    public boolean addRow  (String fieldNames[], String fieldTypes[], Object fieldValues[]) throws Exception
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        for (int i=0;i<fieldNames.length;i++) {
            switch (fieldTypes[i])
            {
                case BYTE:
                    Byte byteValue = (Byte)fieldValues[i];
                    contentValues.put(fieldNames[i],byteValue);
                    break;
                case SHORT:
                    Short shortValue = (Short)fieldValues[i];
                    contentValues.put(fieldNames[i],shortValue);
                    break;
                case INTEGER:
                    Integer integerValue = (Integer)fieldValues[i];
                    contentValues.put(fieldNames[i],integerValue);
                    break;
                case LONG:
                    Long longValue = (Long)fieldValues[i];
                    contentValues.put(fieldNames[i],longValue);
                    break;
                case FLOAT:
                    Float floatValue = (Float)fieldValues[i];
                    contentValues.put(fieldNames[i],floatValue);
                    break;
                case DOUBLE:
                    Double doubleValue = (Double)fieldValues[i];
                    contentValues.put(fieldNames[i],doubleValue);
                    break;
                case STRING:
                    String stringValue = (String)fieldValues[i];
                    contentValues.put(fieldNames[i],stringValue);
                    break;

            }


        }
        // Insert the row
        long nr= db.insert(tableName, null, contentValues);
        db.close(); //close database connection
        return nr> -1;
    }
    //This method returns a Cursor object which holds the table row with the given id
    //The following argument should be passed:
    // id - an Object which holds the primary key value
    // fieldName - the field name for the primary key field
    public Cursor getRowById(Object id, String fieldName) throws Exception{
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor =  db.rawQuery( "select * from " + tableName + " where "+ fieldName + "='"+id.toString()+"'", null );
        return cursor;
    }


    public boolean editRow (String[] fieldNames, String fieldTypes[], Object fieldValues[])
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        for (int i=1;i<fieldNames.length;i++) {
            switch (fieldTypes[i]) {
                case BYTE:
                    Byte byteValue = (Byte) fieldValues[i];
                    contentValues.put(fieldNames[i], byteValue);
                    break;
                case SHORT:
                    Short shortValue = (Short) fieldValues[i];
                    contentValues.put(fieldNames[i], shortValue);
                    break;
                case INTEGER:
                    Integer integerValue = (Integer) fieldValues[i];
                    contentValues.put(fieldNames[i], integerValue);
                    break;
                case LONG:
                    Long longValue = (Long) fieldValues[i];
                    contentValues.put(fieldNames[i], longValue);
                    break;
                case FLOAT:
                    Float floatValue = (Float) fieldValues[i];
                    contentValues.put(fieldNames[i], floatValue);
                    break;
                case DOUBLE:
                    Double doubleValue = (Double) fieldValues[i];
                    contentValues.put(fieldNames[i], doubleValue);
                    break;
                case STRING:
                    String stringValue = (String) fieldValues[i];
                    contentValues.put(fieldNames[i], stringValue);
                    break;
            }

        }
        //
        int nr = db.update(tableName, contentValues, fieldNames[0] + " = ? ", new String[]{String.valueOf(fieldValues[0])});
        return nr > 0;
    }


}
