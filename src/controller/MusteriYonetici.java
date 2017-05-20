/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.Customer;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Kadir
 */
public class MusteriYonetici {
    private List musterilerList; 
    private  JTable musteriTablo;
    private final static String SORGU_KALIP="from Customer c where c.";
    private Session session;

    public MusteriYonetici(JTable musteriTablo) {
        this.musteriTablo = musteriTablo;
    }
    
    public void ac()
    {
        session=HibernateUtil.getSessionFactory().openSession();
    }
    public void kapat()
    {
        session.close();
    }
    public void musteriGetir(String aranan,String filtre)
    {
        String sorguMetin="";
        if(filtre.equalsIgnoreCase("ad"))
            sorguMetin=SORGU_KALIP+"name like '"+aranan+"%'";
        else
            sorguMetin=SORGU_KALIP+"city like '"+aranan+"%'";
        try {
            session.beginTransaction();
            Query sorgu = session.createQuery(sorguMetin);
            musterilerList=sorgu.list();
            
            session.getTransaction().commit();
            musteriGoster();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
             
    }
    public void musteriGoster()
    {
        Vector<String>sutunlar = new Vector<>();
        Vector musteriVektor = new Vector();
        sutunlar.add("Müşteri ID");
        sutunlar.add("Ad Soyad");
        sutunlar.add("Şehir");
        for(Object gelenMusteri:musterilerList){
        Customer musteri=(Customer)gelenMusteri;
            Vector<Object> satir=new Vector<>();
            satir.add(musteri.getCustomerId());
            satir.add(musteri.getName());
            satir.add(musteri.getCity());
            musteriVektor.add(satir);
        }
        musteriTablo.setModel(new DefaultTableModel(musteriVektor,sutunlar));
    }
    
}
