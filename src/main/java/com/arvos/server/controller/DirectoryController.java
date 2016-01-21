package com.arvos.server.controller;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.arvos.server.DirectorySvcApi;
import com.arvos.server.model.Augment;
import com.arvos.server.model.AugmentDao;
import com.arvos.server.model.Directory;
import com.arvos.server.model.DirectoryDao;
import com.google.common.collect.Lists;

@Controller
public class DirectoryController implements DirectorySvcApi {

	@Autowired
	private DirectoryDao directoryDao;

	@RequestMapping(value = DirectorySvcApi.DIRECTORY_TEST_PATH, method = RequestMethod.GET)
	public @ResponseBody Directory directoryTest(
			@RequestParam(value = "name", defaultValue = "Arvos_directory") String name) {
		return new Directory(String.format("Directory Test title:, %s!", name));
	}

	/**
	 * DirectorySvcApi.DIRECTORY_SVC_PATH = "/directory-service"
	 */
	@RequestMapping(value = DirectorySvcApi.DIRECTORY_SVC_PATH, method = RequestMethod.GET)
	public @ResponseBody Collection<Directory> getDirectoryList() {
		return Lists.newArrayList(directoryDao.findAll());
	}

	@RequestMapping(value = DirectorySvcApi.DIRECTORY_SEARCH_PATH, method = RequestMethod.GET)
	public @ResponseBody Collection<Directory> getDirectories(@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "lat", required = false) Double lat,
			@RequestParam(value = "lon", required = false) Double lon,
			@RequestParam(value = "alt", required = false) Double alt,
			@RequestParam(value = "azi", required = false) Double azi,
			@RequestParam(value = "ver", required = false) String ver,
			@RequestParam(value = "plat", required = false) String plat,
			@RequestParam(value = "dkey", required = false) String dkey) {
		ArrayList<Directory> dirList = new ArrayList<>();
		return Lists.newArrayList(directoryDao.findAllByName(name));
	}

	// TODO- figure out input variables in the format ?q=1222....
	@RequestMapping(value = DirectorySvcApi.DIRECTORY_CREATE_PATH, method = RequestMethod.POST)
	public @ResponseBody String createDirectory(@RequestParam(value = "name", required = false) String name) {
		Directory dir = null;
		try {
			dir = new Directory(name);
			directoryDao.save(dir);
		} catch (Exception ex) {
			return "Error creating the Directory: " + ex.toString();
		}
		return "Directory succesfully created! (id = " + dir.getId() + ")";
	}

	@RequestMapping(value = DirectorySvcApi.DIRECTORY_UPDATE_PATH, method = RequestMethod.POST)
	public @ResponseBody String updateDirectory(@PathVariable Long id,
			@RequestParam(value = "lat", required = false) Double lat,
			@RequestParam(value = "lon", required = false) Double lon,
			@RequestParam(value = "alt", required = false) Double alt,
			@RequestParam(value = "azi", required = false) Double azi,
			@RequestParam(value = "ver", required = false) String ver,
			@RequestParam(value = "plat", required = false) String plat,
			@RequestParam(value = "plat", required = false) String dkey) {
		Directory dir = directoryDao.findOne(id);
		try {
			// TODO - update the Directory.
		} catch (Exception ex) {
			return "Error updating the Directory: " + ex.toString();
		}
		return "Directory succesfully Updated! (id = " + dir.getId() + ")";
	}

	@RequestMapping(value = DirectorySvcApi.DIRECTORY_DELETE_PATH, method = RequestMethod.DELETE)
	public @ResponseBody String deleteDirectory(@PathVariable Long id) {
		Directory dir = directoryDao.findOne(id);

		// TODO fix response entity error.
		// if (dir == null) return new
		// ResponseEntity<String>(HttpStatus.NOT_FOUND); // 404

		try {
			directoryDao.delete(id);
		} catch (Exception ex) {
			return "Error deleting the Directory: " + ex.toString();
		}
		return "Directory succesfully Deleted! (id = " + id + ")";
		// TODO return http success.
	}
}