import { Component } from '@angular/core';
import { HeaderComponent } from "../../core/header/header.component";
import { FooterComponent } from "../../core/footer/footer.component";
import { MainSectionComponent } from "../../core/main-section/main-section.component";

@Component({
  selector: 'app-dashboared',
  imports: [HeaderComponent, FooterComponent, MainSectionComponent],
  templateUrl: './dashboared.component.html',
  styleUrl: './dashboared.component.css'
})
export class DashboaredComponent {

}
