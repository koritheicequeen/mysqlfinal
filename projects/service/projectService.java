package projects.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import project.entity.Project;
import projects.dao.ProjectDao;
import projects.exception.DbException;

public class projectService {
	private static ProjectDao projectDao = new ProjectDao();

	public static Project addProject(Project project) {
			  return projectDao.insertProject(project);

			
	}

	public static List<Project> fetchAllProjects() {
		// TODO Auto-generated method stub
		return projectDao.fetchAllProjects();

	}

	public static Project fetchProjectById(Integer projectId) {
		
		return projectDao.fetchProjectById(projectId).orElseThrow(() -> new NoSuchElementException("Project with project ID=" +projectId + " does not exist."));
	}

	

	public static void modifyProjectDetails(Project project) {
		// TODO Auto-generated method stub
		if (!projectDao.modifyProjectDetails(project)) {
			throw new DbException("Project with ID = " + project.getProjectId() + " does not exist");
		}
		
	}
	//@param projectId
public static void deleteProject(Integer projectId) {
		// TODO Auto-generated method stub

	if(!projectDao.deleteProject(projectId)) {
		throw new DbException("Project with ID = " + projectId + " does not exist");
	}
		
		
		
	}
}
