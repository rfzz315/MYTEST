import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.util.Progressable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;



import static org.junit.Assert.*;
import java.io.*;

public class APP{
    private FileSystem fileSystem;
    private Configuration conf;
    @Before
    public void before() throws IOException {
        conf=new Configuration();

        /*
         * 第一种方式：直接使用代码设置相关参数
         * */
        //configuration.set("fs.defaultFS", "hdfs://Hadoop01:8020");


        /*
         * 第二种方式 使用配置文件的方式
         *
         * */

        //configuration.addResource("core-site.xml");
        //configuration.addResource("hdfs-site.xml");
        conf.addResource("core-site.xml");
        conf.addResource("hdfs-site.xml");
        fileSystem=FileSystem.newInstance(conf);
    }

    @Test
    public void testConfig(){
        String value = conf.get("dfs.replication");
        System.out.println(value);
    }

    @Test
    public void testUpload01() throws Exception {
        String file="C:\\Users\\CJZ\\Desktop\\123.txt";
        System.out.println("1");
        Path dst=new Path("/456.txt");
        System.out.println("2");
        FileInputStream fis  = new FileInputStream(file);
        System.out.println("3");
        FSDataOutputStream dos=fileSystem.create(dst);
        System.out.println("4");
        IOUtils.copyBytes(fis,dos,1024,true);
        System.out.println("5");
    }
    @Test
    public void testUpload02() throws IOException {
        Path src=new Path("C:\\Users\\HIAPAD\\Desktop\\SpringBoot启动原理.pdf");
        Path dst=new Path("/springBoot1.pdf");
        fileSystem.copyFromLocalFile(src,dst);
    }

    @Test
    public void testDownload01() throws IOException {
        String file="C:\\Users\\HIAPAD\\Desktop\\SpringBoot启动原理1.pdf";
        Path dst=new Path("/springBoot.pdf");
        OutputStream os  = new FileOutputStream(file);
        InputStream is = fileSystem.open(dst);
        IOUtils.copyBytes(is,os,1024,true);
    }
    @Test
    public void testDownload02() throws IOException {
        Path dst=new Path("C:\\Users\\HIAPAD\\Desktop\\SpringBoot启动原理3.pdf");
        Path src=new Path("/springBoot1.pdf");
        //fileSystem.copyToLocalFile(src,dst);
        fileSystem.copyToLocalFile(false,src,dst,true);
    }
    @Test
    public void testDelete() throws IOException {
        Path src=new Path("/user");

        fileSystem.delete(src,true);//true 表示递归删除子文件夹
    }

    @Test
    public void testExists() throws IOException {
        Path src=new Path("/springBoot1.pdf");
        boolean exists = fileSystem.exists(src);
        assertTrue(exists);
    }
    @Test
    public void testMkdir() throws IOException {
        Path src=new Path("/demo/access");
        boolean exists = fileSystem.exists(src);
        if(!exists){
            fileSystem.mkdirs(src);
        }
    }
    @Test
    public void testListFiles() throws IOException {
        Path src=new Path("/");
        RemoteIterator<LocatedFileStatus> files = fileSystem.listFiles(src, true);

        while (files.hasNext()){
            LocatedFileStatus file = files.next();
            System.out.println(file.getPath()+" "+file.isFile()+" "+file.getLen());
            BlockLocation[] locations = file.getBlockLocations();
            for (BlockLocation location : locations) {
                System.out.println("offset:"+location.getOffset()+",length:"+location.getLength());
            }
        }

    }
    @Test
    public void testDeleteWithTrash() throws IOException {
        Trash trash=new Trash(fileSystem,conf);
        Path dst=new Path("/springBoot1.pdf");
        trash.moveToTrash(dst);
    }

    @After
    public void after() throws IOException {
        fileSystem.close();
    }

}
