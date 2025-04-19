import { Component, inject } from '@angular/core';
import { UserDataI } from '../../inerfaces/user-data-i';
import { FormsModule } from '@angular/forms';
import { ApiServiceService } from '../../services/api-service.service';

@Component({
  selector: 'app-main-section',
  imports: [FormsModule],
  templateUrl: './main-section.component.html',
  styleUrl: './main-section.component.css',
})
export class MainSectionComponent {
  guthubUrl: string = '';
  number: number = 0;
  apiservice = inject(ApiServiceService);
  iserror = false;
  isloading = false;
  getdata() {
    this.iserror = false;
    this.isloading = true;
    const data: UserDataI = {
      gitHubUrl: this.guthubUrl,
      number: this.number,
    };
    this.apiservice.getIncreseViewApi(data).subscribe((res: any) => {
      this.isloading = false;
      console.log(res);
    }),
      (error: any) => {
        this.isloading = false;
        console.log('running error');
        alert('fsdfsd');
        this.iserror = true;
        console.log(error);
      };
  }
}
