2013-04-29 Weicheng Zhu <weicheng@dreamhunter.me>

- Add

	* Save dialog, save the idMat using objectoutputstream

2013-04-26 Weicheng Zhu <weicheng@dreamhunter.me>

- Add

	* Login menu (for socket connection)

- Modify
	
	* isHead, isBody, isNULL variables in cell class are deleted. The new idea is to use id as a flag, if id is 1, 2 or 3, this cell is body, 
	if id is 11, 22 or 33, this cell is head, if id is 0, this cell is null. 
	

2013-04-24 Weicheng Zhu <weicheng@dreamhunter.me>

- Add

	* Ready button added. When ready button is clicked, left panel is not clickable.
	* Right click to cancel the current deploy of the plane.
	* Click action when game started.

2013-04-22  Weicheng Zhu  <weicheng@dreamhunter.me>

- Add

    * skyPanel.java (skyPanel:actionlistener): Change buttons' attributes(`isNull`,`isBody`, `isHead`) when mouse clicked.

    * cell.java : Add `init()` method for `cell` class
