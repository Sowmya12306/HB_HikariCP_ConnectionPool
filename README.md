Configuration of Hibernate (hibernate.cfg.xml) using HikariCP(Production use)

hibernate.cfg.xml
-----------------
<property name="hibernate.connection.provider_class">org.hibernate.hikaricp.internal.HikariCPConnectionProvider</property>
<!-- Maximum waiting time for a connection from the pool -->
<property name="hibernate.hikari.connectionTimeout">10000</property>
<!-- Minimum number of ideal connections in the pool -->
<property name="hibernate.hikari.minimumIdle">15</property>
<!-- Maximum number of actual connection in the pool -->
<property name="hibernate.hikari.maximumPoolSize">25</property>
<!-- Maximum time that a connection is allowed to sit ideal in the pool -->
<property name="hibernate.hikari.idleTimeout">200000</property>						   
