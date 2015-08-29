package domPa_resXML.login;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import domPa_resXML.dao.PersonDao;
import domPa_resXML.daoImpl.PersonDaoImpl;
import domPa_resXML.entity.Person;

public class PersonLogin {
  private static final String xmlPath = "com/bochy/xml/person.xml";

  public static void main(String[] args) throws Exception {

    PersonDao dao = new PersonDaoImpl();
    InputStream inputStream = System.in;
    InputStreamReader reader = new InputStreamReader(inputStream);
    BufferedReader bufferedReader = new BufferedReader(reader);
    while (true){
      System.out.println("************欢迎使用该系统：A注册，B登陆**************");
      String welcomeFlag = bufferedReader.readLine();
      if (welcomeFlag != null && welcomeFlag.equals("A")){// 表示注册操作
        System.out.println("*************正在注册*******************");
        System.out.println("***输入注册身份证号（身份证号为18位）:");
        String registerCardno = bufferedReader.readLine();
        System.out.println("***输入注册姓名:");
        String registerName = bufferedReader.readLine();
        System.out.println("***输入注册年龄:");
        String registerAge = bufferedReader.readLine();
        System.out.println("***输入注册地址:");
        String registerAddress = bufferedReader.readLine();
        System.out.println("***输入注册出生日期:");
        String registerBirthday = bufferedReader.readLine();

        Person person = new Person();
        person.setName(registerName);
        person.setAge(Integer.parseInt(registerAge));
        person.setBirthday(registerBirthday);
        person.setCardno(registerCardno);
        person.setAddress(registerAddress);
        dao.addPerson(person, xmlPath);

        System.out.println("***********请登陆该系统（账号统一为个人身份证号码，密码后三位）************");
        System.out.println("***********确认登陆（L）或退出（E）************");

        String loginOrExtFlag = bufferedReader.readLine();
        if (loginOrExtFlag != null && "L".equals(loginOrExtFlag)){
          System.out.println("***输入用户名：");
          String username = bufferedReader.readLine();
          System.out.println("***输入密码：");
          String pwd = bufferedReader.readLine();

          Boolean b = dao.login(username, pwd, xmlPath);// 验证登陆操作
          if (b){// 表示登陆成功
            System.out
                .println("*************选择操作：1、查询个人信息；2、修改个人信息、3、注销个人信息、4查看所有人员信息*****************");
            String controlFlag = bufferedReader.readLine();
            if (controlFlag != null && !"".equals(controlFlag)){
              if (controlFlag.equals("1")){// 查询个人信息
                Person p = dao.selectPersonByCardno(username, xmlPath);
                System.out.println("个人信息如下：");
                System.out.println("身份证号码：" + p.getCardno() + ":姓名："
                    + p.getName() + ":年龄:" + p.getAge() + ":地址："
                    + p.getAddress() + ":出生日期" + p.getBirthday());
              } else if (controlFlag.equals("2")){// 修改个人信息
                System.out.println("请输入修改的个人信息：");
                System.out.println("输入修改的姓名：");
                String uName = bufferedReader.readLine();
                System.out.println("输入修改的年龄：");
                String uAge = bufferedReader.readLine();
                System.out.println("输入修改的地址：");
                String uAddress = bufferedReader.readLine();
                System.out.println("输入修改的出生日期：");
                String uBirthday = bufferedReader.readLine();

                Person up = new Person();
                up.setCardno(username);
                up.setName(uName);
                up.setAddress(uAddress);
                up.setBirthday(uBirthday);
                up.setAge(Integer.parseInt(uAge));
                try{
                  dao.updatePerson(up, xmlPath);
                  System.out.println("修改成功");

                  // 修改成功后在查询一次；
                  Person p = dao.selectPersonByCardno(username, xmlPath);
                  System.out.println("个人信息如下：");
                  System.out.println("身份证号码：" + p.getCardno() + ":姓名："
                      + p.getName() + ":年龄:" + p.getAge() + ":地址："
                      + p.getAddress() + ":出生日期" + p.getBirthday());
                } catch (Exception e){
                  e.printStackTrace();
                }

              } else if (controlFlag.equals("3")){// 注销个人信息
                System.out.println("********您确认要注销么？Y/N*********");
                String deleteCardno = bufferedReader.readLine();
                if (deleteCardno != null && "Y".equals(deleteCardno)){
                  try{
                    dao.deletePerson(username, xmlPath);
                    System.out.println("注销成功！");
                    List<Person> list = dao.selectPersonList(xmlPath);
                    if (list != null && list.size() > 0){
                      for (int i = 0; i < list.size(); i++){
                        Person sp = list.get(i);
                        System.out.println("身份证号码：" + sp.getCardno() + ":姓名："
                            + sp.getName() + ":年龄:" + sp.getAge() + ":地址："
                            + sp.getAddress() + ":出生日期" + sp.getBirthday());
                      }
                    }
                  } catch (Exception e){
                    e.printStackTrace();
                  }

                } else{
                  break;
                }

              } else if (controlFlag.equals("4")){
                List<Person> list = dao.selectPersonList(xmlPath);
                if (list != null && list.size() > 0){
                  for (int i = 0; i < list.size(); i++){
                    Person sp = list.get(i);
                    System.out.println("身份证号码：" + sp.getCardno() + ":姓名："
                        + sp.getName() + ":年龄:" + sp.getAge() + ":地址："
                        + sp.getAddress() + ":出生日期" + sp.getBirthday());
                  }
                }
              } else{
                break;
              }

            }

          } else{
            System.out.println("登录失败，退出");
            break;
          }

        }

      } else if (welcomeFlag != null && welcomeFlag.equals("B")){// 登陆操作
        System.out.println("***请输入用户名：");
        String username = bufferedReader.readLine();
        System.out.println("***请输入密码：");
        String pwd = bufferedReader.readLine();

        Boolean b = dao.login(username, pwd, xmlPath);// 验证登陆操作
        if (b){// 表示登陆成功
          System.out
              .println("*************选择操作：1、查询个人信息；2、修改个人信息、3、注销个人信息、4查看所有人员信息*****************");
          String controlFlag = bufferedReader.readLine();
          if (controlFlag != null && !"".equals(controlFlag)){
            if (controlFlag.equals("1")){// 查询个人信息
              Person p = dao.selectPersonByCardno(username, xmlPath);
              System.out.println("个人信息如下：");
              System.out.println("身份证号码：" + p.getCardno() + ":姓名："
                  + p.getName() + ":年龄:" + p.getAge() + ":地址：" + p.getAddress()
                  + ":出生日期" + p.getBirthday());
            } else if (controlFlag.equals("2")){// 修改个人信息
              System.out.println("请输入修改的个人信息：");
              System.out.println("输入修改的姓名：");
              String uName = bufferedReader.readLine();
              System.out.println("输入修改的年龄：");
              String uAge = bufferedReader.readLine();
              System.out.println("输入修改的地址：");
              String uAddress = bufferedReader.readLine();
              System.out.println("输入修改的出生日期：");
              String uBirthday = bufferedReader.readLine();

              System.out.println(uAge + "年龄");
              Person up = new Person();
              up.setCardno(username);
              up.setName(uName);
              up.setAddress(uAddress);
              up.setBirthday(uBirthday);
              up.setAge(Integer.parseInt(uAge));
              try{
                dao.updatePerson(up, xmlPath);
                System.out.println("修改成功");

                // 修改成功后在查询一次；
                Person p = dao.selectPersonByCardno(username, xmlPath);
                System.out.println("个人信息如下：");
                System.out.println("身份证号码：" + p.getCardno() + ":姓名："
                    + p.getName() + ":年龄:" + p.getAge() + ":地址："
                    + p.getAddress() + ":出生日期" + p.getBirthday());
              } catch (Exception e){
                e.printStackTrace();
              }

            } else if (controlFlag.equals("3")){// 注销个人信息
              System.out.println("********您确认要注销么？Y/N*********");
              String deleteCardno = bufferedReader.readLine();
              if (deleteCardno != null && "Y".equals(deleteCardno)){
                try{
                  dao.deletePerson(username, xmlPath);
                  System.out.println("注销成功！");
                  List<Person> list = dao.selectPersonList(xmlPath);
                  if (list != null && list.size() > 0){
                    for (int i = 0; i < list.size(); i++){
                      Person sp = list.get(i);
                      System.out.println("身份证号码：" + sp.getCardno() + ":姓名："
                          + sp.getName() + ":年龄:" + sp.getAge() + ":地址："
                          + sp.getAddress() + ":出生日期" + sp.getBirthday());
                    }
                  }
                } catch (Exception e){
                  e.printStackTrace();
                }

              } else{
                break;
              }

            } else if (controlFlag.equals("4")){
              List<Person> list = dao.selectPersonList(xmlPath);
              if (list != null && list.size() > 0){
                for (int i = 0; i < list.size(); i++){
                  Person sp = list.get(i);
                  System.out.println("身份证号码：" + sp.getCardno() + ":姓名："
                      + sp.getName() + ":年龄:" + sp.getAge() + ":地址："
                      + sp.getAddress() + ":出生日期" + sp.getBirthday());
                }
              }
            } else{
              break;
            }

          }

        } else{
          System.out.println("登录失败，已退出");
          break;
        }

      }

    }

  }

}
