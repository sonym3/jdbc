select avg(e.salary), r.REGION_NAME
from regions r
join countries c
on r.REGION_ID = c.REGION_ID
join LOCATIONS l
on l.COUNTRY_ID = c.COUNTRY_ID
join DEPARTMENTS d
on d.LOCATION_ID = l.LOCATION_ID
join EMPLOYEES e 
on e.DEPARTMENT_ID = d.DEPARTMENT_ID
group by r.REGION_NAME;
