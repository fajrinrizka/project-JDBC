/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Job;

/**
 *
 * @author User
 */
public interface IJobController {
    public List<Job> getAll();
    public Job getById(String id);
    public List<Job> search(String key);
    public Job insert(String id, String title, String min, String max);
    public Job update(String id, String title, String min, String max);
    public void delete(String id);
}
