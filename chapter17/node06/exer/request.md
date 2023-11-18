# 练习
## 题目要求：

榨汁机榨水果汁，水果有： 苹果（Apple）、香蕉（Banana）、桔子（Orange）等。

## 提示
1. 声明水果（Fruit）接口，包含抽象方法: `void squeeze()`；
2. 声明榨汁机（Juicer），包含运行方法：`public void run(Fruit f)`，方法体中，调用f的榨汁方法`squeeze()`；
3. 声明各种水果类，实现水果接口，并重写 `squeeze()`；
4. 在配置文件(config.properties)中读取 水果名称(fruitName=xxx),按读取的配置动态生成对应的水果对象；
5. 在FruitTest测试类中：
> (1) 读取配置文件，按需动态生成对应的水果对象
> (2) 运行`juicer.run(f)` 。